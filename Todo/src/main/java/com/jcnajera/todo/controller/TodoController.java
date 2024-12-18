package com.jcnajera.todo.controller;

import com.jcnajera.todo.model.Task;
import com.jcnajera.todo.service.ITaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping(value = "/api/tasks")
public class TodoController {

    @Autowired
    private ITaskService service;

    @PostMapping(value = "/")
    public ResponseEntity<?> create(@RequestBody Task task){
        Optional<Task> taskTmp = service.getById(task.getId());
        if (taskTmp.isPresent()){
            return ResponseEntity.badRequest().build();
        }
        Task newTask = service.createTask(task);
        return ResponseEntity.status(HttpStatus.OK).body(task);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> read(@PathVariable Long id){
        Optional<Task> task = service.getById(id);
        if (task.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(task);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Task updatedTask){
        Optional<Task> task = service.getById(id);
        if (task.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        updatedTask.setId(id);
        service.updateTask(updatedTask);
        return ResponseEntity.status(HttpStatus.OK).body(service.updateTask(updatedTask));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        Optional<Task> task = service.getById(id);
        if (task.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        service.deleteTask(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

    @GetMapping(value = "/")
    public List<Task> readAll(){
        return service.getAll().stream().toList();
    }
}

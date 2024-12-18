package com.jcnajera.todo.service;

import com.jcnajera.todo.model.Task;

import java.util.List;
import java.util.Optional;

public interface ITaskService {
    public List<Task> getAll();
    public Optional<Task> getById(Long id);
    public Task createTask(Task task);
    public Task updateTask(Task task);
    public void deleteTask(Long id);
}

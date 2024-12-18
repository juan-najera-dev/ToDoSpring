package com.jcnajera.todo.repository;

import com.jcnajera.todo.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository <Task, Long> {
}

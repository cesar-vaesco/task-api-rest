package com.vaesco.todoapp.service;

import com.vaesco.todoapp.persistence.entity.Task;
import com.vaesco.todoapp.persistence.repository.TaskRepository;
import org.springframework.stereotype.Service;

@Service
public class TaskService {

    // Importando el repository
    private final TaskRepository repository;

    // Creado el constructor del repository - se puede evitar usando autowired
    public TaskService(TaskRepository repository) {
        this.repository = repository;
    }

    public Task createTask(Task task) {
        return null;
    }


}
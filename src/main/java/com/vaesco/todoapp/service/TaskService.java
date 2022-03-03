package com.vaesco.todoapp.service;

import com.vaesco.todoapp.mapper.TaskInDTOToTask;
import com.vaesco.todoapp.persistence.entity.Task;
import com.vaesco.todoapp.persistence.repository.TaskRepository;
import com.vaesco.todoapp.service.dto.TaskInDTO;
import org.springframework.stereotype.Service;

@Service
public class TaskService {

    // Importando el repository
    private final TaskRepository repository;

    private final TaskInDTOToTask mapper;

    // Creado el constructor del repository - se puede evitar usando autowired
    public TaskService(TaskRepository repository, TaskInDTOToTask mapper) {

        this.repository = repository;
        this.mapper = mapper;
    }

    public Task createTask(TaskInDTO taskInDTO) {
        Task task = mapper.map(taskInDTO);

        return this.repository.save(task);
    }


}

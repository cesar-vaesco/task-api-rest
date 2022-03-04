package com.vaesco.todoapp.service;

import com.vaesco.todoapp.exception.TodoExceptions;
import com.vaesco.todoapp.mapper.TaskInDTOToTask;
import com.vaesco.todoapp.persistence.entity.Task;
import com.vaesco.todoapp.persistence.entity.TaskStatus;
import com.vaesco.todoapp.persistence.repository.TaskRepository;
import com.vaesco.todoapp.service.dto.TaskInDTO;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

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


    public List<Task> findAll() {
        return this.repository.findAll();
    }


    public List<Task> findAllByTaskStatus(TaskStatus status) {
        return this.repository.findAllByTaskStatus(status);
    }

    @Transactional
    public void updateTaskFinished(Long id) {
        Optional<Task> optionalTask = this.repository.findById(id);
        if (optionalTask.isEmpty()) {
            throw new TodoExceptions("Task not found", HttpStatus.NOT_FOUND);
        }

        this.repository.updateTaskAndFinished(id);
    }

}

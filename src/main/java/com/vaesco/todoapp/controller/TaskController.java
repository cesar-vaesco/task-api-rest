package com.vaesco.todoapp.controller;


import com.vaesco.todoapp.persistence.entity.Task;
import com.vaesco.todoapp.persistence.entity.TaskStatus;
import com.vaesco.todoapp.service.TaskService;
import com.vaesco.todoapp.service.dto.TaskInDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;
import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {


    /**
     * Usando el constructor para usar instancias de la clase Service TaskService
     * private final TaskService taskService;
     * public TaskController(TaskService taskService) {
     * this.taskService = taskService;
     * }
     */
    @Autowired
    private TaskService taskService;

    @PostMapping
    public Task createTask(@RequestBody TaskInDTO taskInDTO) {
        return this.taskService.createTask(taskInDTO);
    }

    @GetMapping
    public List<Task> findAll() {
        return this.taskService.findAll();
    }

    @GetMapping("/status/{status}")
    public List<Task> findAllTaskStatus(@PathVariable("status") TaskStatus status) {
        return taskService.findAllByTaskStatus(status);
    }

    @PatchMapping("/mark_and_finished/{id}")
    public ResponseEntity<Void> markAndFinished(@PathVariable("id") Long id){
        this.taskService.updateTaskFinished(id);
        return ResponseEntity.noContent().build();
        // Responde como no content por el cambio de status de finalizada la tarea
    }

}

package com.vaesco.todoapp.controller;


import com.vaesco.todoapp.persistence.entity.Task;
import com.vaesco.todoapp.service.TaskService;
import com.vaesco.todoapp.service.dto.TaskInDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;


    @PostMapping
    public Task createTask (@RequestBody TaskInDTO taskInDTO){
        return this.taskService.createTask(taskInDTO);
    }

    @GetMapping
    public List<Task> findAll(){
        return this.taskService.findAll();
    }

}

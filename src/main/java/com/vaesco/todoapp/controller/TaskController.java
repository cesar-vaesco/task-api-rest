package com.vaesco.todoapp.controller;


import com.vaesco.todoapp.persistence.entity.Task;
import com.vaesco.todoapp.service.TaskService;
import com.vaesco.todoapp.service.dto.TaskInDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;


    @PostMapping
    public Task createTask (@RequestBody TaskInDTO taskInDTO){
        return this.taskService.createTask(taskInDTO);
    }


}

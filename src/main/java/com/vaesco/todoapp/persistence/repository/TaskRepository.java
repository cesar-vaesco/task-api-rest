package com.vaesco.todoapp.persistence.repository;

import com.vaesco.todoapp.persistence.entity.Task;
import com.vaesco.todoapp.persistence.entity.TaskStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {

    /*
    * El status es sacado del Enum
    * */
    List<Task> findAllByTaskStatus(TaskStatus status);

}

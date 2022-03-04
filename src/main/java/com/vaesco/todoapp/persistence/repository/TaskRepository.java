package com.vaesco.todoapp.persistence.repository;

import com.vaesco.todoapp.persistence.entity.Task;
import com.vaesco.todoapp.persistence.entity.TaskStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {

    /*
    * El status es sacado del Enum
    * */
    List<Task> findAllByTaskStatus(TaskStatus status);

    @Modifying
    @Query(value = "UPDATE TASK SET FINISHED=true WHERE id=:id ", nativeQuery = true)
    void updateTaskAndFinished(@Param("id") Long id);

}

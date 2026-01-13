package com.aditya.taskmanager.repository;

import com.aditya.taskmanager.entity.Task;
import com.aditya.taskmanager.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByOwner(User owner);
}

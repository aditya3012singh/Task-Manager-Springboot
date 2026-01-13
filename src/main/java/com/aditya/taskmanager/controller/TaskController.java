package com.aditya.taskmanager.controller;

import com.aditya.taskmanager.dto.request.TaskCreateRequest;
import com.aditya.taskmanager.dto.response.TaskCreateReponse;

import com.aditya.taskmanager.service.TaskService;
import com.aditya.taskmanager.service.TaskServiceImpl;
import jakarta.validation.Valid;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private  final TaskService taskService;

    public TaskController(TaskService taskService){
        this.taskService=taskService;
    }

//    @PreAuthorize("hasRole('USER')")
    @PreAuthorize("hasAuthority('TASK_CREATE')")
//    @PreAuthorize("hasAuthority('task:create')")
    @PostMapping
    public TaskCreateReponse createTask(@Valid @RequestBody TaskCreateRequest request){
        return taskService.createTask(request);
    }

//    @PreAuthorize("hasRole('USER')")
@   PreAuthorize("hasAuthority('TASK_READ')")
//    @PreAuthorize("hasAuthority('task:read')")
    @GetMapping
    public List<TaskCreateReponse> getMyTasks(){
        return taskService.getMyTasks();
    }

//    @PreAuthorize("hasRole('ADMIN')")
//    @GetMapping("/all")
//    public List<TaskCreateReponse> getAllTasks() {
//        return taskService.getAllTasks();
//    }

//    @PreAuthorize("hasAuthority('TASK_DELETE')")
//    @DeleteMapping("/{id}")
//    public void deleteTask(@PathVariable Long id) {
//        taskService.deleteTask(id);
//    }


}

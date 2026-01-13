package com.aditya.taskmanager.service;

import com.aditya.taskmanager.config.security.SecurityUtil;
import com.aditya.taskmanager.dto.request.TaskCreateRequest;
import com.aditya.taskmanager.dto.response.TaskCreateReponse;
import com.aditya.taskmanager.entity.Task;
import com.aditya.taskmanager.entity.User;
import com.aditya.taskmanager.exception.ResourceNotFoundException;
import com.aditya.taskmanager.repository.TaskRepository;
import com.aditya.taskmanager.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService{
    private final TaskRepository taskRepository;
    private final UserRepository userRepository;

    public TaskServiceImpl(TaskRepository taskRepository, UserRepository userRepository){
        this.taskRepository=taskRepository;
        this.userRepository=userRepository;
    }

    public TaskCreateReponse createTask(TaskCreateRequest request){
        String email= SecurityUtil.getCurrentUserEmail();
        User user= userRepository.findByEmail(email).orElseThrow(() -> new ResourceNotFoundException("User not found"));

        Task task= Task.builder().title(request.getTitle()).description(request.getDescription()).status(request.getStatus()).owner(user).build();

        Task savedTask = taskRepository.save(task);

        return TaskCreateReponse.builder().id(savedTask.getId()).title(savedTask.getTitle()).description(savedTask.getDescription()).status(savedTask.getStatus()).build();
    }

    public List<TaskCreateReponse> getMyTasks(){
        String email = SecurityUtil.getCurrentUserEmail();

        User user= userRepository.findByEmail(email).orElseThrow(()-> new ResourceNotFoundException("User not found"));

        return taskRepository.findByOwner(user)
                .stream()
                .map(task -> TaskCreateReponse.builder()
                        .id(task.getId())
                        .title(task.getTitle())
                        .description(task.getDescription())
                        .status(task.getStatus())
                        .build())
                .toList();
    }

    public List<TaskCreateReponse> getAllTasks() {
        return taskRepository.findAll()
                .stream()
                .map(task -> TaskCreateReponse.from(task))
                .toList();
    }

}

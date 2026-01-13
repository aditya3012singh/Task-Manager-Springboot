package com.aditya.taskmanager.service;

import com.aditya.taskmanager.dto.request.TaskCreateRequest;
import com.aditya.taskmanager.dto.response.TaskCreateReponse;

import java.util.List;

public interface TaskService {
    TaskCreateReponse createTask(TaskCreateRequest request);
    List<TaskCreateReponse> getMyTasks();
}

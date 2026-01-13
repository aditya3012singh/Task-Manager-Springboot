package com.aditya.taskmanager.dto.response;

import com.aditya.taskmanager.entity.Task;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class TaskCreateReponse {
    private Long id;
    private String title;
    private String description;
    private String status;

    public static TaskCreateReponse from(Task task) {
        return TaskCreateReponse.builder()
                .id(task.getId())
                .title(task.getTitle())
                .description(task.getDescription())
                .status(task.getStatus())
                .build();
    }
}

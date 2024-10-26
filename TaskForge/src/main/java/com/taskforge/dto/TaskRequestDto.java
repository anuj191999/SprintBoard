package com.taskforge.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TaskRequestDto {
    private int taskId;
    private String taskTitle;
    private String taskDescription;
    private String taskStatus;
    private String userId;
}

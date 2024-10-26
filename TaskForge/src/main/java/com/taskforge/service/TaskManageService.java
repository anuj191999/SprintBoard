package com.taskforge.service;

import com.taskforge.dto.TaskRequestDto;
import com.taskforge.dto.TaskResponseDto;
import com.taskforge.model.Item;
import com.taskforge.repositorty.TaskRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class TaskManageService {

    private TaskRepository taskRepository;
    public TaskManageService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public void createTask(TaskRequestDto task) {
        Item item=Item.builder().
                taskId(task.getTaskId())
                .taskDescription(task.getTaskDescription())
                .taskTitle(task.getTaskTitle())
                .taskStatus(task.getTaskStatus())
                .userId(task.getUserId())
                .build();
        this.taskRepository.save(item);

    }

    public void updateTask(TaskRequestDto task) {
        Item item=Item.builder().
                taskId(task.getTaskId())
                .taskDescription(task.getTaskDescription())
                .taskTitle(task.getTaskTitle())
                .taskStatus(task.getTaskStatus())
                .userId(task.getUserId())
                .build();
        this.taskRepository.save(item);
    }

    public void deleteTask(String taskId) {
        this.taskRepository.deleteById(taskId);
    }

    public List<TaskResponseDto> getAllTask(String userId)
    {
        List<Item> items=this.taskRepository.findByUserId(userId);
        List<TaskResponseDto> allTaskList=new ArrayList<TaskResponseDto>();
        for (Item item : items) {

            allTaskList.add(TaskResponseDto.builder()
                    .title(item.getTaskTitle())
                    .description(item.getTaskDescription())
                    .status(item.getTaskStatus())
                    .build()
            );
        }
        return allTaskList;
    }
}

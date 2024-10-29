package com.taskforge.controller;

import com.taskforge.dto.TaskRequestDto;
import com.taskforge.dto.TaskResponseDto;
import com.taskforge.service.TaskManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/task")
public class TaskManagerController {


    @Autowired
    private TaskManageService taskManageService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addTask(@RequestBody TaskRequestDto taskRequestDto) {
        this.taskManageService.createTask(taskRequestDto);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public void updateTask(@RequestBody TaskRequestDto taskRequestDto) {
        this.taskManageService.updateTask(taskRequestDto);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.OK)
    public void deleteTask(@RequestParam(required = true) String taskId) {
        this.taskManageService.deleteTask(taskId);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<TaskResponseDto> getTasks(@RequestParam(required = false) String userId) {
        return this.taskManageService.getAllTask(userId);
    }

}

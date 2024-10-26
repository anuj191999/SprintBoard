package com.taskforge.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(value = "item")
public class Item {

    @Id
    private int taskId;
    private String taskTitle;
    private String taskDescription;
    private String taskStatus;
    private String userId;
}

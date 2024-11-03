package com.authservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(value = "user-account-info")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserAccountInfo {

    @Id
    private long id;
    private String username;
    private String password;
}

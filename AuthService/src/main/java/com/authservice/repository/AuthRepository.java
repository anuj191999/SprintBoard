package com.authservice.repository;

import com.authservice.model.UserAccountInfo;
import com.authservice.model.UserInfo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AuthRepository extends MongoRepository<UserInfo,String> {

    public UserInfo findByUsername(String username);
}

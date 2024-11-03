package com.authservice.repository;

import com.authservice.model.UserAccountInfo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserAccountInfoRepository extends MongoRepository<UserAccountInfo, String> {

    public UserAccountInfo findByUsername(String username);
}

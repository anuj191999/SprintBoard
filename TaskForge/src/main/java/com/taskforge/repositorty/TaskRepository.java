package com.taskforge.repositorty;

import com.taskforge.model.Item;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface TaskRepository extends MongoRepository<Item, String> {
        List<Item> findByUserId(String userId);
}

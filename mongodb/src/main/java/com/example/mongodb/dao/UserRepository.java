package com.example.mongodb.dao;

import com.example.mongodb.pojo.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;


@Service
public interface UserRepository extends MongoRepository<User, String> {
    
   public User findByName(String name); 

}

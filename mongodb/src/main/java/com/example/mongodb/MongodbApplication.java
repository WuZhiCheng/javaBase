package com.example.mongodb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MongodbApplication {
    @Qualifier
    public static void main(String[] args) {
        SpringApplication.run(MongodbApplication.class, args);
    }

}

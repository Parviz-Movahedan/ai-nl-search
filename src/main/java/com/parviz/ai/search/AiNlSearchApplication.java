package com.parviz.ai.search;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class AiNlSearchApplication {

    public static void main(String[] args) {
        SpringApplication.run(AiNlSearchApplication.class, args);
    }

}

package com.example.concumertwo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ConcumerTwoApplication implements CommandLineRunner {
    @Autowired
    ConcumerService concumerService;

    public static void main(String[] args) {
        SpringApplication.run(ConcumerTwoApplication.class, args);
    }

    @Override
    public void run(String... args) {
        concumerService.recievedMessage();
    }
}

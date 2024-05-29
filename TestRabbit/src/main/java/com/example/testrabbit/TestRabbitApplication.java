package com.example.testrabbit;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@AllArgsConstructor
public class TestRabbitApplication implements CommandLineRunner {

    private final ProducerService producerService;

    public static void main(String[] args) {
        SpringApplication.run(TestRabbitApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        producerService.sendMessage("send " + Math.random());
        producerService.sendMessage2("message 2 " + Math.random());
    }
}

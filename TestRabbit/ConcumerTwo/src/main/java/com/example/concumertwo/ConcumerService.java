package com.example.concumertwo;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class ConcumerService {
    @Autowired
    RabbitTemplate rabbitTemplate;


    public void recievedMessage(){
        rabbitTemplate.setExchange("test-exchange");
        rabbitTemplate.setRoutingKey("test2-routing-key");
        Object o = rabbitTemplate.receiveAndConvert("test2-queue");
        System.out.println(o);
    }

}

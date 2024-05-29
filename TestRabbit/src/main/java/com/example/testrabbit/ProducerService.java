package com.example.testrabbit;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class ProducerService {

    RabbitTemplate rabbitTemplate;

    private static final Logger LOG = LoggerFactory.getLogger(ProducerService.class);

    public void sendMessage(String message) {
        try {
            LOG.info("Sending " + message);
            rabbitTemplate.convertAndSend("test-exchange","test-routing-key" ,message);
            LOG.info("Sented " + message);
        }catch (AmqpException e) {
            e.printStackTrace();
        }
    }

    public void sendMessage2(String message){
        LOG.info("Sending " + message);
        rabbitTemplate.convertAndSend("test-exchange","test2-routing-key" ,message);
        LOG.info("Sented " + message);
    }


}

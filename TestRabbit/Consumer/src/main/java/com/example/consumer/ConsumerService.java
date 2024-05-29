package com.example.consumer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class ConsumerService {

    private final RabbitTemplate rabbitTemplate;
    private static final Logger LOG = LoggerFactory.getLogger(ConsumerService.class);

    public void reciveMesage(){
        try {
            LOG.info("Consumer received");
            rabbitTemplate.setExchange("test-exchange");
            rabbitTemplate.setRoutingKey("test-routing-key");
            Object o = rabbitTemplate.receiveAndConvert("test-queue");
            System.out.println(o);
        }catch (Exception e){
            e.printStackTrace();
        }



    }
}

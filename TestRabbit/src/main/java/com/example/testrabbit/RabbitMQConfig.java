package com.example.testrabbit;


import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class RabbitMQConfig {

    @Value("${spring.rabbitmq.host}")
    private String host;

    @Value("${spring.rabbitmq.port}")
    private Integer port;

    @Value("${spring.rabbitmq.username}")
    private String username;

    @Value("${spring.rabbitmq.password}")
    private String password;
//
//    @Value("${rabbitmq.exchanges.default.type}")
//    private String exchangeType;
//
//    @Value("${rabbitmq.exchanges.default.name}")
//    private String exchangeName;
//
//    @Value("${rabbitmq.bindings.microservice1.routingKey}")
//    private String routingKeyMicroservice1;
//
//    @Value("${rabbitmq.bindings.microservice2.routingKey}")
//    private String routingKeyMicroservice2;

    @Bean
    public ConnectionFactory connectionFactory() {
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory(host);
        connectionFactory.setPort(port);
        connectionFactory.setUsername(username);
        connectionFactory.setPassword(password);
        return connectionFactory;
    }



    @Bean
    public TopicExchange exchange() {
        return new TopicExchange("test-exchange"); // Replace "exchangeName" with your actual exchange name
    }

    @Bean
    public Queue queue1() {
        return new Queue("test-queue"); // Replace "queueName" with your actual queue name
    }
    @Bean
    public Queue queue2() {
        return new Queue("test2-queue"); // Replace "queueName" with your actual queue name
    }


    @Bean
    public Binding binding1(Queue queue1, TopicExchange exchange) {
        return BindingBuilder.bind(queue1).to(exchange).with("test-routing-key");
    }

    @Bean
    public Binding binding2(Queue queue2, TopicExchange exchange) {
        return BindingBuilder.bind(queue2).to(exchange).with("test2-routing-key");
    }



}

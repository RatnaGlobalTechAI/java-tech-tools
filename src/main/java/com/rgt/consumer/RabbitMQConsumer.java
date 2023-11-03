package com.rgt.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import com.rgt.request.UserRequest;

@Service
public class RabbitMQConsumer {

    private  static  final Logger LOGGER = LoggerFactory.getLogger(RabbitMQConsumer.class);

    @RabbitListener(queues = {"${rabbitmq.queue.name}"})
    public void consume(String message){
        LOGGER.info(String.format("Received message -> %s", message));
    }
    
    @RabbitListener(queues = {"${rabbitmq.queue.json.name}"})
    public void consume(UserRequest user){
        LOGGER.info(String.format("Received message -> %s", user));
    }
}

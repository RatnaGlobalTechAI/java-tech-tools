package com.rgt.publisher;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.rgt.request.UserRequest;
import com.rgt.response.ResponseObject;

@Service
public class RabbitMQPublisher {

	@Value("${rabbitmq.queue.exchange}")
	private String exchange;

	@Value("${rabbitmq.queue.routing.key}")
	private String routingKey;
	
    @Value("${rabbitmq.queue.json.routing.key}")
    private String jsonRoutingKey;
	

	private static final Logger LOGGER = LoggerFactory.getLogger(RabbitMQPublisher.class);

	private RabbitTemplate rabbitTemplate;

	public RabbitMQPublisher(RabbitTemplate rabbitTemplate) {
		this.rabbitTemplate = rabbitTemplate;
	}

	public ResponseObject sendMessage(String message) {
		ResponseObject response = new ResponseObject();

		try {
			LOGGER.info(String.format("Message sent -> %s", message));
			rabbitTemplate.convertAndSend(exchange, routingKey, message);

			 rabbitTemplate.convertSendAndReceive(exchange, routingKey, message);
			

				response.setStatus(true);
				response.setSuccessMessage("Message send to consumer");
		}catch (Exception e) {
			response.setStatus(false);
			response.setErrorMessage(e.getMessage());
		}
		
		
		return response;
	}

	public ResponseObject sendMessageWithRequest(UserRequest userRequest) {
		ResponseObject response = new ResponseObject();

		try {
			LOGGER.info(String.format("Message sent -> %s", userRequest));
			// rabbitTemplate.convertAndSend(exchange, routingKey, message);
			CorrelationData correlationData = new CorrelationData();
	        correlationData.setId(UUID.randomUUID().toString());
	        
			 rabbitTemplate.convertSendAndReceive(exchange, jsonRoutingKey, userRequest ,correlationData);
			
				LOGGER.info("Respone : Message send to consumer");
				response.setStatus(true);
				response.setSuccessMessage("User request send to consumer");
	
			
		}catch(Exception e) {
			response.setErrorMessage(e.getMessage());
			response.setStatus(false);
		}
		
		return response;
	}
	
	

}

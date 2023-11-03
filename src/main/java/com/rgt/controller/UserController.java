package com.rgt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rgt.publisher.RabbitMQPublisher;
import com.rgt.request.UserRequest;
import com.rgt.response.ResponseObject;

@RestController
public class UserController {

	@Autowired
	private RabbitMQPublisher rabbitMQPublisher;
	
	

	public UserController(RabbitMQPublisher rabbitMQPublisher) {
		this.rabbitMQPublisher = rabbitMQPublisher;
	}

	@GetMapping("/sendMessage")
	public ResponseObject sendMessage(@RequestParam("message") String message) {
		ResponseObject response = new ResponseObject();
		response = rabbitMQPublisher.sendMessage(message);

		return response;
	}

	@PostMapping("/message")
	public ResponseObject sendMessageWithRequest(@RequestBody UserRequest userRequest) {
		ResponseObject response = new ResponseObject();
		response = rabbitMQPublisher.sendMessageWithRequest(userRequest);

		return response;
	}

}

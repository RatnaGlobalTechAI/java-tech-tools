package com.rgt.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rgt.request.UserRequest;
import com.rgt.response.ResponseObject;
import com.rgt.service.UserService;
import com.rgt.utils.URLConstant;


@RestController
public class UserController {
	
	private static Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserService userService; 
	
	@PostMapping(value = "/sign-up")
	public ResponseObject userCreation(@RequestBody UserRequest userRequest) {
		ResponseObject response = new ResponseObject();
		response = userService.createAccount(userRequest);
		logger.info("Sign Up Response "+response);
		return response;
		
	}
	
	@PutMapping(value = URLConstant.UPDATE_USER)
	public ResponseObject updateUser(@RequestParam String emailId, @RequestBody UserRequest userRequest) {
		return userService.updateUser(emailId, userRequest);

	}

}

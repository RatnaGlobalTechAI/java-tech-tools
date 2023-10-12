package com.rgt.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rgt.request.UserRequest;
import com.rgt.response.ResponseObject;
import com.rgt.service.MailService;
import com.rgt.utils.URLConstant;

@RestController
public class EmailController {
	
	@Autowired
	private MailService mailService;
	
	
	
	private static Logger logger = LogManager.getLogger(EmailController.class);
	
	@PostMapping(value = URLConstant.SendDataViaMail)
	public ResponseObject sendBaseReport(@RequestParam String senders) {
		ResponseObject response = mailService.sendDataByEmailWithBody(senders);    //mailService.sendDataByEmail(senders);
		if (response == null || response.equals(""))
			response.setErrorMessage("Error In Reporting");  
		logger.info("sendBaseReport() - " + response);
		return response;
	}

	@PostMapping(value = URLConstant.SendDataViaMail)
	public ResponseObject sendUserEmail(@RequestBody UserRequest userRequest) {
		ResponseObject response = mailService.sendDataByEmailWithBody(userRequest);    //mailService.sendDataByEmail(senders);
		if (response == null || response.equals(""))
			response.setErrorMessage("Error In Reporting");
		logger.info("sendBaseReport() - " + response);
		return response;
	}

}

package com.rgt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rgt.request.WhatsAppRequest;
import com.rgt.response.ResponseObject;
import com.rgt.service.WhatsAppService;

@RestController
public class WhatsAppNotificationController {
	
	@Autowired
	private WhatsAppService whatsAppService;
	
	
	@PostMapping("/send-notification")
	public ResponseObject sendWhatsAppNotification(@RequestBody WhatsAppRequest whatsappRequest) {
		return whatsAppService.sendWhatsAppNotification(whatsappRequest);
		
	}

}

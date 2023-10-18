package com.rgt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rgt.request.WhatsAppDataRequest;
import com.rgt.response.ResponseObject;
import com.rgt.service.WhatsAppService;

@RestController
public class WhatsAppNotificationDataController {
	
	@Autowired
	private WhatsAppService whatsAppService;
	
	@PostMapping("/data-insert")
	public ResponseObject dataInsert(@RequestBody WhatsAppDataRequest whatsappDataRequest) {
		return whatsAppService.dataInsert(whatsappDataRequest);
		
	}

}

package com.rgt.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rgt.request.AuditLogRequest;
import com.rgt.response.ResponseObject;
import com.rgt.service.AuditLoggingService;

@RestController
public class AuditLogController {
	
	private static Logger logger = LoggerFactory.getLogger(AuditLogController.class);
	
	@Autowired
	private AuditLoggingService auditLoggingService; 
	
	
	@PostMapping(value = "/audit-log")
	public ResponseObject auditLog(@RequestBody AuditLogRequest auditLogRequest) {
		ResponseObject response = new ResponseObject();
		response = auditLoggingService.auditLog(auditLogRequest);
		logger.info("Audit Log Response "+response);
		return response;
		
	}


}

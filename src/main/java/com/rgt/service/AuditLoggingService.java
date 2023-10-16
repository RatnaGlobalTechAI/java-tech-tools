package com.rgt.service;

import com.rgt.request.AuditLogRequest;
import com.rgt.response.ResponseObject;

public interface AuditLoggingService {

	ResponseObject auditLog(AuditLogRequest auditLogRequest);

}

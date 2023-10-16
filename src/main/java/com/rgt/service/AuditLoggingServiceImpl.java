package com.rgt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rgt.entity.AuditLogEntity;
import com.rgt.repository.AuditLogRepository;
import com.rgt.request.AuditLogRequest;
import com.rgt.response.ResponseObject;
import com.rgt.utils.CommonUtility;

@Repository
public class AuditLoggingServiceImpl implements AuditLoggingService {
	
	@Autowired
	private AuditLogRepository auditLogRepository;
	
	@Autowired
	private SequenceGeneratorService sequenceGeneratorService;
	
	

	@Override
	public ResponseObject auditLog(AuditLogRequest auditLogRequest) {
		ResponseObject response = new ResponseObject();
		
		try {
			
			AuditLogEntity auditLogEntity = new AuditLogEntity();
			auditLogEntity.setId(sequenceGeneratorService.generateSequence(AuditLogEntity.SEQUENCE_NAME));
			auditLogEntity.setEmail(auditLogRequest.getEmail());
			auditLogEntity.setExistingValue(auditLogRequest.getExistingValue().toString());
			auditLogEntity.setModifyValue(auditLogRequest.getModifyValue().toString());
			auditLogEntity.setModifyTo(CommonUtility.convertStringToDate(auditLogRequest.getModifyTo()));
			auditLogRepository.save(auditLogEntity);
			
			response.setStatus(true);
			response.setSuccessMessage("Audit log data saved successfully");;
			
		}catch(Exception e){
			response.setErrorMessage(e.getMessage());
			response.setStatus(false);
			
		}
		

		return response;
	}

}

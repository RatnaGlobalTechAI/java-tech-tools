package com.rgt.service;

import java.util.Date;

import org.bson.json.JsonObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rgt.entity.RegisterUserEntity;
import com.rgt.repository.RegisterUserRepository;
import com.rgt.request.AuditLogRequest;
import com.rgt.request.UserRequest;
import com.rgt.response.ResponseObject;
import com.rgt.utils.CommonUtility;

@Service
public class UserServiceImpl implements UserService {

	private static Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	@Autowired
	private RegisterUserRepository registerUserRepository;

	@Autowired
	private AuditLoggingService auditLoggingService;

	@Autowired
	private SequenceGeneratorService sequenceGeneratorService;

	@Override
	public ResponseObject createAccount(UserRequest userRequest) {
		ResponseObject response = new ResponseObject();

		try {

			if (registerUserRepository.existsByEmailId(userRequest.getEmailId()))
				throw new ResponseStatusException(HttpStatus.CONFLICT,
						"User account already exists for provided email");

			RegisterUserEntity registerUserEntity = new RegisterUserEntity();
			registerUserEntity.setId(sequenceGeneratorService.generateSequence(RegisterUserEntity.SEQUENCE_NAME));
			registerUserEntity.setEmailId(userRequest.getEmailId());
			registerUserEntity.setPassword(userRequest.getPassword());
			registerUserEntity.setEmailVerified(true);
			registerUserEntity.setActive(true);
			registerUserEntity.setUsername(userRequest.getUsername());
			registerUserEntity.setCreatedOn(new Date());

			registerUserRepository.save(registerUserEntity);

			response.setStatus(true);
			response.setSuccessMessage("User account create successfully");
		} catch (Exception e) {

			response.setErrorMessage(e.getMessage());
			response.setStatus(false);

		}

		return response;

	}

	@Override
	public ResponseObject updateUser(String emailId, UserRequest userRequest) {
		ResponseObject response = new ResponseObject();
		try {

			if (userRequest != null) {
				RegisterUserEntity registerUserEntity = registerUserRepository.findByEmailId(emailId);
				if (registerUserEntity != null) {

					
					registerUserEntity.setEmailId(userRequest.getEmailId());
					registerUserEntity.setPassword(userRequest.getPassword());
					registerUserEntity.setEmailVerified(true);
					registerUserEntity.setActive(true);
					registerUserEntity.setUsername(userRequest.getUsername());
					registerUserEntity.setUpdatedOn(new Date());
					registerUserRepository.save(registerUserEntity);
					
					
					

					
					//audit log saved data
					ObjectMapper objectMapper = new ObjectMapper();
					String existingValue = objectMapper.writeValueAsString(userRequest);
					String modifyValue = objectMapper.writeValueAsString(registerUserEntity);
					
					AuditLogRequest auditLogRequest = new AuditLogRequest();
					auditLogRequest.setEmail(registerUserEntity.getEmailId());
					auditLogRequest.setExistingValue(existingValue);
					auditLogRequest.setModifyValue(modifyValue.toString());
					auditLogRequest.setModifyTo(CommonUtility.getTodayDate());

					ResponseObject auditLogResponse = auditLoggingService.auditLog(auditLogRequest);
					logger.info(auditLogResponse.toString());

					
					logger.info("User data update successfully");

				} else {
					response.setErrorMessage("User not exist");
					response.setStatus(false);
				}

			}

		} catch (Exception e) {

			response.setErrorMessage(e.getMessage());
			response.setStatus(false);
		}
		return response;
	}

}

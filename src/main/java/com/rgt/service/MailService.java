package com.rgt.service;

import java.util.Date;

import com.rgt.request.UserRequest;
import com.rgt.response.ResponseObject;

public interface MailService {

	ResponseObject sendDataByEmail(String senders);

	ResponseObject sendDataByEmailWithBody(UserRequest userRequest);

	void sendEmail(String toMail, String subject, String messageBody);

	boolean sendMail(String string, String emailId);

	void emailNotificationStatusSavedToDB(String resposneStatus, String senders, String messageBody,
			Date notificationSendOn, String username);

}

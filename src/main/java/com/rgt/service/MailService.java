package com.rgt.service;

import com.rgt.request.UserRequest;
import com.rgt.response.ResponseObject;

public interface MailService {

	ResponseObject sendDataByEmail(String senders);

	ResponseObject sendDataByEmailWithBody(String senders);

	void sendEmail(String toMail, String subject, String messageBody);

	ResponseObject sendDataByEmailWithBody(UserRequest userRequest);

	boolean sendMail(String string, String emailId);

}

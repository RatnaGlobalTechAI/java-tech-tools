package com.rgt.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.rgt.request.WhatsAppRequest;
import com.rgt.response.ResponseObject;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

@Service
public class WhatsAppServiceImpl implements WhatsAppService{
	
	@Value("${twilio.account.sid}")
    private String accountSid;

    @Value("${twilio.auth.token}")
    private String authToken;
    
    @Value("${twilio.phoneNumber}")
    private String phoneNumber;

    public void sendWhatsAppMessage(String to, String message) {
        Twilio.init(accountSid, authToken);
        PhoneNumber toPhoneNumber = new PhoneNumber("whatsapp:" + to);
        PhoneNumber fromPhoneNumber = new PhoneNumber("whatsapp:"+phoneNumber);
        Message.creator(toPhoneNumber, fromPhoneNumber, message).create();
    }

	@Override
	public ResponseObject sendWhatsAppNotification(WhatsAppRequest whatsappRequest) {
		ResponseObject response = new ResponseObject();
		
		try {
			
			if(whatsappRequest !=null) {
				sendWhatsAppMessage(whatsappRequest.getMobileNumber(), whatsappRequest.getMessage());
			}
			
		}catch(Exception e) {
			
			response.setErrorMessage(e.getMessage());
			response.setStatus(false);
		}
		
		return response;
	}

}

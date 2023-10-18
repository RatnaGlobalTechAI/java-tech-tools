package com.rgt.controller;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

public class TestController {
	
	
		public static final String ACCOUNT_SID = "ACdc48b75b064532886c3dfbb0b9fecc36";
		  public static final String AUTH_TOKEN = "b00da83d0a9aa1c19adc535f2d55be58";
		  public static final PhoneNumber PHONE_NUMBER = new PhoneNumber("+14155238886");

		  public static void main(String[] args) {
//		    Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
//		    Message message = Message.creator(
//		      new com.twilio.type.PhoneNumber("+919158091575"),
//		      new com.twilio.type.PhoneNumber("+19032244660"),
//		      "welcome".create();
			  Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
		        PhoneNumber toPhoneNumber = new PhoneNumber("whatsapp:+919158091575");
		        
		        PhoneNumber fromPhoneNumber = new PhoneNumber("whatsapp:"+PHONE_NUMBER);
		        String message = "welcome to RGT";
				Object string =   Message.creator(toPhoneNumber, fromPhoneNumber, message).create();
		        

		    System.out.println(string.toString());
		  
    }

}

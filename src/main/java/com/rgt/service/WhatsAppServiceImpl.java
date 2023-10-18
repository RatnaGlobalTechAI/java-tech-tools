package com.rgt.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.rgt.entity.WhatsAppNotificationDataEntity;
import com.rgt.repository.WhatsAppNotificationDataRepository;
import com.rgt.request.WhatsAppDataRequest;
import com.rgt.request.WhatsAppRequest;
import com.rgt.response.ResponseObject;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

@Service
public class WhatsAppServiceImpl implements WhatsAppService {

	@Value("${twilio.account.sid}")
	private String accountSid;

	@Value("${twilio.auth.token}")
	private String authToken;

	@Value("${twilio.phoneNumber}")
	private String phoneNumber;

	@Autowired
	private SequenceGeneratorService sequenceGeneratorService;

	@Autowired
	private WhatsAppNotificationDataRepository whatsAppNotificationDataRepository;

	public Object sendWhatsAppMessage(String to, String message) {
		Twilio.init(accountSid, authToken);
		PhoneNumber toPhoneNumber = new PhoneNumber("whatsapp:" + to);

		PhoneNumber fromPhoneNumber = new PhoneNumber("whatsapp:" + phoneNumber);
		return Message.creator(toPhoneNumber, fromPhoneNumber, message).create();
	}

	@Override
	public ResponseObject sendWhatsAppNotification(WhatsAppRequest whatsappRequest) {
		ResponseObject response = new ResponseObject();

		try {

			WhatsAppNotificationDataEntity whatsAppNotificationDataEntity = whatsAppNotificationDataRepository
					.findByMobileNumber(whatsappRequest.getMobileNumber());

			if (whatsAppNotificationDataEntity != null) {
				String whatsapp = null;
				if (whatsappRequest.getMessage().contains("{{1}}")) {

					whatsapp = whatsappRequest.getMessage().replace("{{1}}",
							whatsAppNotificationDataEntity.getOrder1());
					// System.out.println(""+whatsapp);
				}

				if (whatsappRequest.getMessage().contains("{{2}}")) {
					whatsapp = whatsapp.replace("{{2}}", whatsAppNotificationDataEntity.getOrder2());

				}

				if (whatsappRequest.getMessage().contains("{{3}}")) {
					whatsapp = whatsapp.replace("{{3}}", whatsAppNotificationDataEntity.getOrder3());

				}
				if (whatsappRequest.getMessage().contains("{{4}}")) {
					whatsapp = whatsapp.replace("{{4}}", whatsAppNotificationDataEntity.getOrder4());

				}

				Object object = sendWhatsAppMessage(whatsappRequest.getMobileNumber(), whatsapp);
				System.out.println("Twilio Respoinse = " + object);
			}

		} catch (Exception e) {

			response.setErrorMessage(e.getMessage());
			response.setStatus(false);
		}

		return response;
	}

	@Override
	public ResponseObject dataInsert(WhatsAppDataRequest whatsappDataRequest) {
		ResponseObject response = new ResponseObject();
		try {

			WhatsAppNotificationDataEntity whatsAppNotificationDataEntity = new WhatsAppNotificationDataEntity();
			whatsAppNotificationDataEntity
					.setId(sequenceGeneratorService.generateSequence(WhatsAppNotificationDataEntity.SEQUENCE_NAME));
			whatsAppNotificationDataEntity.setMobileNumber(whatsappDataRequest.getMobileNumber());
			whatsAppNotificationDataEntity.setOrder1(whatsappDataRequest.getOrder1());
			whatsAppNotificationDataEntity.setOrder2(whatsappDataRequest.getOrder2());
			whatsAppNotificationDataEntity.setOrder3(whatsappDataRequest.getOrder3());
			whatsAppNotificationDataEntity.setOrder4(whatsappDataRequest.getOrder4());
			whatsAppNotificationDataEntity.setOrder5(whatsappDataRequest.getOrder5());
			whatsAppNotificationDataEntity.setCreatedOn(new Date());

			whatsAppNotificationDataRepository.save(whatsAppNotificationDataEntity);

		} catch (Exception e) {
			response.setErrorMessage(e.getMessage());
			response.setStatus(false);
		}

		return response;
	}

}

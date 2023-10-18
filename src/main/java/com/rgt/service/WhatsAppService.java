package com.rgt.service;

import com.rgt.request.WhatsAppDataRequest;
import com.rgt.request.WhatsAppRequest;
import com.rgt.response.ResponseObject;

public interface WhatsAppService {

	ResponseObject sendWhatsAppNotification(WhatsAppRequest whatsappRequest);

	ResponseObject dataInsert(WhatsAppDataRequest whatsappDataRequest);

}

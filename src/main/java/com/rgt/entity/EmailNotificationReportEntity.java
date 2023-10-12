package com.rgt.entity;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


//@Entity
//@Table(name = "email_notification_report")
@Document("email_notification_report")
public class EmailNotificationReportEntity {
	
	
	@Id
	//@Column(name = "ID")
	private long id;
	
	//@Column(name = "EMAIL")
	private String email;
	

	//@Column(name = "MESSAGE_BODY")
	private String message;
	
	//@Column(name = "STATUS")
	private String status;
	
	//@Column(name = "USERNAME")
	private String username;
	
	//@Column(name = "NOTIFICATION_SENT_ON")
	private Date notificationSentOn;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Date getNotificationSentOn() {
		return notificationSentOn;
	}

	public void setNotificationSentOn(Date notificationSentOn) {
		this.notificationSentOn = notificationSentOn;
	}

	

}

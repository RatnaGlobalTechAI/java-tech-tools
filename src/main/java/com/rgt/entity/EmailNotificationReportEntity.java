package com.rgt.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "email_notification_report")
public class EmailNotificationReportEntity {
	
	
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "EMAIL")
	private String email;
	

	@Column(name = "MESSAGE_BODY")
	private String message;
	
	@Column(name = "STATUS")
	private String status;
	
	@Column(name = "USERNAME")
	private String username;
	
	@Column(name = "NOTIFICATION_SENT_ON")
	private Date notificationSentOn;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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

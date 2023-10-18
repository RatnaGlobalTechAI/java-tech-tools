package com.rgt.entity;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("whatsapp_notification_data")
public class WhatsAppNotificationDataEntity {
	
	@Transient
	 public static final String SEQUENCE_NAME = "users_sequence";
	
	@Id
	private Long id;
	private String mobileNumber;
	private String order1;
	private String order2;
	private String order3;
	private String order4;
	private String order5;
	private Date createdOn;
	
	
	
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getOrder1() {
		return order1;
	}
	public void setOrder1(String order1) {
		this.order1 = order1;
	}
	public String getOrder2() {
		return order2;
	}
	public void setOrder2(String order2) {
		this.order2 = order2;
	}
	public String getOrder3() {
		return order3;
	}
	public void setOrder3(String order3) {
		this.order3 = order3;
	}
	public String getOrder4() {
		return order4;
	}
	public void setOrder4(String order4) {
		this.order4 = order4;
	}
	public String getOrder5() {
		return order5;
	}
	public void setOrder5(String order5) {
		this.order5 = order5;
	}
	public Date getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}
	
	

}

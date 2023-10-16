package com.rgt.entity;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "audit_log")
public class AuditLogEntity implements Serializable {
	
	@Transient
	 public static final String SEQUENCE_NAME = "users_sequence";
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private Long id;
	
	private String email;
	
	private String existingValue;
	
	private String modifyValue;
	
	private Date modifyTo;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getExistingValue() {
		return existingValue;
	}

	public void setExistingValue(String existingValue) {
		this.existingValue = existingValue;
	}

	public String getModifyValue() {
		return modifyValue;
	}

	public void setModifyValue(String modifyValue) {
		this.modifyValue = modifyValue;
	}

	public Date getModifyTo() {
		return modifyTo;
	}

	public void setModifyTo(Date modifyTo) {
		this.modifyTo = modifyTo;
	}
	
	

}

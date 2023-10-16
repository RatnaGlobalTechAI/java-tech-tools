package com.rgt.request;

public class AuditLogRequest {
	
	private String email;
	private Object existingValue;
	private Object modifyValue;
	private String modifyTo;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Object getExistingValue() {
		return existingValue;
	}
	public void setExistingValue(Object existingValue) {
		this.existingValue = existingValue;
	}
	public Object getModifyValue() {
		return modifyValue;
	}
	public void setModifyValue(Object modifyValue) {
		this.modifyValue = modifyValue;
	}
	public String getModifyTo() {
		return modifyTo;
	}
	public void setModifyTo(String modifyTo) {
		this.modifyTo = modifyTo;
	}
	
	
	

}

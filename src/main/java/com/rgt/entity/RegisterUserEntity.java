package com.rgt.entity;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonInclude;

@Document(collection  = "register_user")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RegisterUserEntity implements Serializable {
	
	 private static final long serialVersionUID = -3492266417550204992L;
	 
	 @Transient
	 public static final String SEQUENCE_NAME = "users_sequence";
	
	 @Id	
	 private Long id;
	
	private String username;
	
	private String address;
	
	private String city;
	
	private String pincode;
	
	private String dob;
	
	private Date createdOn;
	
	private Date updatedOn;
	
    private String emailId;

    private String password;

    private boolean isEmailVerified;

    private boolean isActive;
    
    //new column added 11-10-2023
    private String secondaryEmail;

    private String officeAddress;
    
    private String communicationAddress;
    
    
    
    
	
	



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getSecondaryEmail() {
		return secondaryEmail;
	}



	public void setSecondaryEmail(String secondaryEmail) {
		this.secondaryEmail = secondaryEmail;
	}



	public String getOfficeAddress() {
		return officeAddress;
	}



	public void setOfficeAddress(String officeAddress) {
		this.officeAddress = officeAddress;
	}



	public String getCommunicationAddress() {
		return communicationAddress;
	}



	public void setCommunicationAddress(String communicationAddress) {
		this.communicationAddress = communicationAddress;
	}



	public RegisterUserEntity() {
	}



	public RegisterUserEntity(String username, String address, String city, String pincode, String dob,String emailId) {
		this.username = username;
		this.address = address;
		this.city = city;
		this.pincode = pincode;
		this.dob = dob;
		this.emailId =emailId;
	}
	
	

	public String getEmailId() {
		return emailId;
	}



	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public boolean isEmailVerified() {
		return isEmailVerified;
	}



	public void setEmailVerified(boolean isEmailVerified) {
		this.isEmailVerified = isEmailVerified;
	}



	public boolean isActive() {
		return isActive;
	}



	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}



	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public Date getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}

//	public String getId() {
//		return id;
//	}
//
//	public void setId(String id) {
//		this.id = id;
//	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}



	@Override
	public String toString() {
		return "[username=" + username + ", address=" + address + ", city=" + city + ", pincode="
				+ pincode + ", dob=" + dob + ", createdOn=" + createdOn + ", updatedOn=" + updatedOn + ", emailId="
				+ emailId + ", password=" + password + ", isEmailVerified=" + isEmailVerified + ", isActive=" + isActive
				+ ", secondaryEmail=" + secondaryEmail + ", officeAddress=" + officeAddress + ", communicationAddress="
				+ communicationAddress + "]";
	}
	
	
	
	
	
	
	

}

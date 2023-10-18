package com.rgt.request;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class WhatsAppDataRequest {
	
	private String mobileNumber;
	private String order1;
	private String order2;
	private String order3;
	private String order4;
	private String order5;
	
	
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
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
	
	

}

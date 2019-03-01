package com.idemia.HiringProject.form;

import javax.validation.constraints.*;

public class CandidateForm {
	
	private String panCardNumber;
	
	private String firstName;
	
	private String lastName;
	
	
	@Size(min=10, max=10, message="Mobile Number should be 10 digit")
	private String mobileNumber;
	
	//@Email (message="Enter valid Email Id")
	private String mailId;

	public String getPanCardNumber() {
		return panCardNumber;
	}

	public void setPanCardNumber(String panCardNumber) {
		this.panCardNumber = panCardNumber;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getMailId() {
		return mailId;
	}

	public void setMailId(String mailId) {
		this.mailId = mailId;
	}
	

}

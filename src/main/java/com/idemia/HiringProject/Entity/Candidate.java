package com.idemia.HiringProject.Entity;
/**
 * 
 * @author G521742
 *
 */

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "candidate")
public class Candidate implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	//@UniquePanNumber(message="Pan Number already exists")
	private String candidate_id;

	@Column(name = "candidate_email")
	private String candidateEmailID;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "contact_number")
	private String mobileNumber;

	@Column(name = "status")
	private String status;

	@Column(name = "requirement_id")
	private String requirementID;
	
	@Column(name = "date_of_entry")
	private String dateOfEntry;
	

	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "candidate_id", referencedColumnName = "candidate_id")
	@JsonManagedReference
	private Interview interview;

	public Candidate() {

	}


	public Candidate(String candidateEmailID, String firstName, String lastName, String mobileNumber, String status,
			String requirementID) {
		super();
		this.candidateEmailID = candidateEmailID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobileNumber = mobileNumber;
		this.status = status;
		this.requirementID = requirementID;
	}

	public String getCandidate_id() {
		return candidate_id;
	}

	public void setCandidate_id(String candidate_id) {
		this.candidate_id = candidate_id;
	}

	public String getCandidateEmailID() {
		return candidateEmailID;
	}

	public void setCandidateEmailID(String candidateEmailID) {
		this.candidateEmailID = candidateEmailID;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRequirementID() {
		return requirementID;
	}

	public void setRequirementID(String requirementID) {
		this.requirementID = requirementID;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Interview getInterview() {
		return interview;
	}

	public void setInterview(Interview interview) {
		this.interview = interview;
	}


	@Override
	public String toString() {
		return "Candidate [candidate_id=" + candidate_id + ", candidateEmailID=" + candidateEmailID + ", firstName="
				+ firstName + ", lastName=" + lastName + ", mobileNumber=" + mobileNumber + ", status=" + status
				+ ", requirementID=" + requirementID + ", interview=" + interview + "]";
	}


	public String getDateOfEntry() {
		return dateOfEntry;
	}


	public void setDateOfEntry(String dateOfEntry) {
		this.dateOfEntry = dateOfEntry;
	}


}

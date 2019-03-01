package com.idemia.HiringProject.Entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

/**
 * 
 * @author G521774
 *
 */
@Entity
@Table(name = "interview")
public class Interview implements Serializable{

	
	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "candidate_id", referencedColumnName = "candidate_id")
	@JsonBackReference
	@MapsId
	private Candidate candidate;
	
	@Id
//	@GeneratedValue(generator = "newGenerator")
//	@GenericGenerator(name= "newGenerator",strategy="foreign",parameters=@org.hibernate.annotations.Parameter(value="candidate", name = "property"))
	
	private String candidate_id;

	@Column(name = "online_test_score")
	private String onlineTestScore;

	@Column(name = "first_level_name")
	private String firstLevelName;

	@Column(name = "first_level_feedback")
	private String firstLevelFeedback;

	@Column(name = "second_level_name")
	private String secondLevelName;

	@Column(name = "second_level_feedback")
	private String secondLevelFeedback;

	@Column(name = "third_level_name")
	private String thirdLevelName;

	@Column(name = "third_level_feedback")
	private String thirdLevelFeedback;

	@Column(name = "status")
	private String status;

	@Column(name = "date_of_offer")
	private String dateOfOffer;

	@Column(name = "joining_date")
	private String joiningDate;

	@Column(name = "revised_joining_date")
	private String revisedJoiningDate;

	

	public String getOnlineTestScore() {
		return onlineTestScore;
	}

	public void setOnlineTestScore(String onlineTestScore) {
		this.onlineTestScore = onlineTestScore;
	}

	public String getFirstLevelName() {
		return firstLevelName;
	}

	public void setFirstLevelName(String firstLevelName) {
		this.firstLevelName = firstLevelName;
	}

	public String getFirstLevelFeedback() {
		return firstLevelFeedback;
	}

	public void setFirstLevelFeedback(String firstLevelFeedback) {
		this.firstLevelFeedback = firstLevelFeedback;
	}

	public String getSecondLevelName() {
		return secondLevelName;
	}

	public void setSecondLevelName(String secondLevelName) {
		this.secondLevelName = secondLevelName;
	}

	public String getSecondLevelFeedback() {
		return secondLevelFeedback;
	}

	public void setSecondLevelFeedback(String secondLevelFeedback) {
		this.secondLevelFeedback = secondLevelFeedback;
	}

	public String getThirdLevelName() {
		return thirdLevelName;
	}

	public void setThirdLevelName(String thirdLevelName) {
		this.thirdLevelName = thirdLevelName;
	}

	public String getThirdLevelFeedback() {
		return thirdLevelFeedback;
	}

	public void setThirdLevelFeedback(String thirdLevelFeedback) {
		this.thirdLevelFeedback = thirdLevelFeedback;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDateOfOffer() {
		return dateOfOffer;
	}

	public void setDateOfOffer(String dateOfOffer) {
		this.dateOfOffer = dateOfOffer;
	}

	public String getJoiningDate() {
		return joiningDate;
	}

	public void setJoiningDate(String joiningDate) {
		this.joiningDate = joiningDate;
	}

	public String getRevisedJoiningDate() {
		return revisedJoiningDate;
	}

	public void setRevisedJoiningDate(String revisedJoiningDate) {
		this.revisedJoiningDate = revisedJoiningDate;
	}

	public String getCandidate_id() {
		return candidate_id;
	}

	public void setCandidate_id(String candidate_id) {
		this.candidate_id = candidate_id;
	}

	public Interview() {

	}

	

	public Interview(String pancard, String onlineTestScore, String firstLevelName, String firstLevelFeedback,
			String secondLevelName, String secondLevelFeedback, String thirdLevelName, String thirdLevelFeedback,
			String status, String dateOfOffer, String joiningDate, String revisedJoiningDate) {
		super();
		this.candidate_id = pancard;
		this.onlineTestScore = onlineTestScore;
		this.firstLevelName = firstLevelName;
		this.firstLevelFeedback = firstLevelFeedback;
		this.secondLevelName = secondLevelName;
		this.secondLevelFeedback = secondLevelFeedback;
		this.thirdLevelName = thirdLevelName;
		this.thirdLevelFeedback = thirdLevelFeedback;
		this.status = status;
		this.dateOfOffer = dateOfOffer;
		this.joiningDate = joiningDate;
		this.revisedJoiningDate = revisedJoiningDate;
	}

	public Candidate getCandidate() {
		return candidate;
	}

	public void setCandidate(Candidate candidate) {
		this.candidate = candidate;
	}

	@Override
	public String toString() {
		return "Interview [candidate=" + candidate + ", candidate_id=" + candidate_id + ", onlineTestScore="
				+ onlineTestScore + ", firstLevelName=" + firstLevelName + ", firstLevelFeedback=" + firstLevelFeedback
				+ ", secondLevelName=" + secondLevelName + ", secondLevelFeedback=" + secondLevelFeedback
				+ ", thirdLevelName=" + thirdLevelName + ", thirdLevelFeedback=" + thirdLevelFeedback + ", status="
				+ status + ", dateOfOffer=" + dateOfOffer + ", joiningDate=" + joiningDate + ", revisedJoiningDate="
				+ revisedJoiningDate + "]";
	}

}

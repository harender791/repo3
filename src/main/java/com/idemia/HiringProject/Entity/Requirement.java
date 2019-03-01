package com.idemia.HiringProject.Entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="requirement")
public class Requirement {
		
	
	@Id
	@Column(name="requirementID",unique=true,nullable=false)
	private String requirementID;
	
	@Column(name="type")
	private String type;
	
	@Column(name="domain")
	private String domain;
	
	@Column(name="sub_domain")
	private String subDomain;
	
	@Column(name="reporting_manager")
	private String reportingManager;
	
	@Column(name="status")
	private String status;

	public String getRequirementID() {
		return requirementID;
	}

	public void setRequirementID(String requirementID) {
		this.requirementID = requirementID;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public String getSubDomain() {
		return subDomain;
	}

	public void setSubDomain(String subDomain) {
		this.subDomain = subDomain;
	}

	public String getReportingManager() {
		return reportingManager;
	}

	public void setReportingManager(String reportingManager) {
		this.reportingManager = reportingManager;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
		
}
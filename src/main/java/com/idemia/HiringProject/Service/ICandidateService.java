package com.idemia.HiringProject.Service;
import java.sql.SQLException;
import java.util.List;

import com.idemia.HiringProject.Entity.Candidate;
import com.idemia.HiringProject.form.CandidateForm;

/**
 * 
 * @author G521742
 *
 */
public interface ICandidateService {
     
	public List<CandidateForm> getAllCandidate();
     //Candidate getCandidateById(int i);
     
     public List<Candidate> getCandidateByEmailID(String candidateemailID);
     
     
     public List<Candidate> getCandidateByPanNumber(String panCard);
     
     boolean addCandidate(CandidateForm candidateForm) throws SQLException;

     public void updateCandidate(CandidateForm info);

	public void deleteCandidate(String panCard);

	public List<String> getRequirementID();

	public void addDetails(Candidate candidate);

	public List<Candidate> searchCandidate(String panCard, String emailID, String status, String startDate, String endDate);
} 
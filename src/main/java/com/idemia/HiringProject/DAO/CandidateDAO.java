package com.idemia.HiringProject.DAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.idemia.HiringProject.Entity.Candidate;
import com.idemia.HiringProject.Entity.Interview;
import com.idemia.HiringProject.form.CandidateForm;

@Transactional
@Repository

public class CandidateDAO implements ICandidateDAO {

	@PersistenceContext
	private EntityManager entityManager;

	public Candidate getCandidateById(int id) {
		return entityManager.find(Candidate.class, id);
	}

	public List<Candidate> getCandidateByPanNumber(String panCard) {
		String hql = "FROM Candidate as can WHERE can.candidate_id= ?";
		List<Candidate> ls = new ArrayList<>();
		ls = entityManager.createQuery(hql).setParameter(1, panCard).getResultList();
		// Query data = entityManager.createQuery(hql).setParameter(1, panCard);
		// System.out.println(data);
		return ls;
	}

	public List<Candidate> getCandidateByEmailID(String candidateemailID) {
		String hql = "FROM Candidate as can WHERE can.candidateEmailID= ? ";
		List<Candidate> ls = new ArrayList<>();
		ls = entityManager.createQuery(hql).setParameter(1, candidateemailID).getResultList();

		return ls;
	}

	public List<CandidateForm> getAllCandidate() {
		String hql = "FROM Candidate as can";
		List<CandidateForm> ls = new ArrayList<>();
		ls = entityManager.createQuery(hql).getResultList();
		return ls;
	}

	public String addCandidate(Candidate candidate) throws SQLException {
		try {
			entityManager.persist(candidate);

		} catch (Exception e) {
			// TODO Log the database Exception
			e.printStackTrace();
		}
		return null;
	}

	public void updateCandidate(CandidateForm candidate) {
		List<Candidate> can = getCandidateByPanNumber(candidate.getPanCardNumber());
		Candidate c = can.get(0);
		c.setFirstName(candidate.getFirstName());
		c.setLastName(candidate.getLastName());
		c.setCandidateEmailID(candidate.getMailId());
		c.setMobileNumber(candidate.getMobileNumber());
		entityManager.flush();
	}

	public void deleteCandidate(String panCard) {
		entityManager.remove(getCandidateByPanNumber(panCard));
	}

	@Override
	public List<String> getRequirementID() {
		String hql = "SELECT R.requirementID FROM Requirement R";
		// List<String> ls=new ArrayList<>();
		List<String> ls = entityManager.createQuery(hql).getResultList();
		// System.out.println("Hello");
		// System.out.println(entityManager.createQuery(hql).getResultList());
		return ls;
	}

	@Override
	public void addDetails(Candidate candidate) {

		Interview interview=new Interview();
		interview.setCandidate(candidate);
		//interview.setStatus(candidate.getStatus());
		
		candidate.setInterview(interview);
		
		entityManager.persist(candidate);
		
	}

	@Override
	public List<Candidate> searchCandidate(String panCard, String emailID, String status, String startDate,String endDate) {
		
		StringBuilder s = new StringBuilder("FROM Candidate as can WHERE 1=1 AND ");
		if (panCard != null && panCard!="") {
			s.append("candidate_id="+"'" + panCard + "'" + " AND ");
		}
		if(emailID!=null && emailID!=""){
			s.append("candidate_email="+"'" + emailID + "'" + " AND ");
		}
		if(status!=null && status!=""){
			s.append("status="+"'" + status + "'" + " AND ");
		}
		if(startDate!=null && endDate!=null && startDate!="" && endDate!=""){
			s.append("date_of_entry BETWEEN "+"'" + startDate + " 00:00:00'" + " AND "+ "'" +endDate+" 00:00:00'" + " AND ");
		}
		
		
		s.append("1=1");
				
		System.out.println(s);
		
		List<Candidate> ls = new ArrayList<>();

		ls = entityManager.createQuery(new String(s)).getResultList();

		return ls;
	}

}
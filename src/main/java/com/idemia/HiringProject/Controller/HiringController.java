package com.idemia.HiringProject.Controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.idemia.HiringProject.Entity.Candidate;
import com.idemia.HiringProject.Service.ICandidateService;
import com.idemia.HiringProject.form.CandidateForm;

//import com.idemia.HiringProject.Entity.Requirement;
/**
 * 
 * @author G521774
 */

@RestController
public class HiringController {

	@Autowired
	private ICandidateService candidateService;

	@CrossOrigin
	@RequestMapping(value = "/addCandidate", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void saveCandidateDetails(@Valid @RequestBody CandidateForm candidateForm, BindingResult bindingResult) {

		//Invoke validate method to
		String errorMessage = validateInput(candidateForm, bindingResult);
		System.out.println(errorMessage);

		try {
			candidateService.addCandidate(candidateForm);
		} catch (SQLException e) {
			//Auto-generated catch block
			e.printStackTrace();
		}
	}

	private String validateInput(CandidateForm candidateForm, BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			System.out.println(bindingResult.getFieldError().getField());
			return "Error";
		} else
			return "No error";

	}

	@RequestMapping(value = "/candidateDetails", method = RequestMethod.GET)
	@ResponseBody
	public List<Candidate> getCandidateDetails(@RequestParam("panCard") String panCard,
			@RequestParam("emailID") String emailID) {

		List<Candidate> can = new ArrayList<>();

		if (emailID != null) {
			can = candidateService.getCandidateByEmailID(emailID);
		} else if (panCard != null) {
			can = candidateService.getCandidateByPanNumber(panCard);
		}
		return can;

	}

	@CrossOrigin
	@RequestMapping(value = "/candidateDetailbyPan", method = RequestMethod.GET)
	@ResponseBody
	public List<Candidate> getCandidateByPan(@RequestParam("panCard") String panCard) {

		List<Candidate> can = new ArrayList<>();

		if (panCard != null) {
			can = candidateService.getCandidateByPanNumber(panCard);
		}

		return can;

	}

	@CrossOrigin
	@RequestMapping(value = "/editCandidate", method = RequestMethod.PUT)
	@ResponseBody
	public String updateCandidate(@RequestParam("panCard") String panCard) {
		CandidateForm info = new CandidateForm();
		if (panCard != null) {
			candidateService.updateCandidate(info);
			return " Successfully update";
		} else {
			return "Update Failed";
		}

	}

	@CrossOrigin
	@RequestMapping(value = "/deleteCandidate", method = RequestMethod.DELETE)
	@ResponseBody
	public void deleteCandidate(@RequestParam("panCard") String panCard) {
		candidateService.deleteCandidate(panCard);

	}

	@CrossOrigin
	@RequestMapping(value = "/allCandidate", method = RequestMethod.GET)
	@ResponseBody
	public List<CandidateForm> getAllCandidates() {
		List<CandidateForm> list = candidateService.getAllCandidate();
		return list;

	}

	@CrossOrigin
	@RequestMapping(value = "/requirementID", method = RequestMethod.GET)
	@ResponseBody
	public List<String> getRequirementID() {
		List<String> list = candidateService.getRequirementID();
		return list;
	}

	@PersistenceContext
	private EntityManager entityManager;

	// @Transactional
	@CrossOrigin
	@RequestMapping(value = "/addDetails", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public boolean addDetails(@Valid @RequestBody Candidate candidate) {

		candidateService.addDetails(candidate);
		
		
		
		
		//return new ResponseEntity<ExceptionResponse>(response, HttpStatus);
		// entityManager.persist(candidate);
		return true;

	}

	@CrossOrigin
	@Transactional
	@RequestMapping(value = "/editDetails", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void editDetails(@RequestBody Candidate candidate) {
		//System.out.println(candidate);
		entityManager.merge(candidate);

	}
	
	@CrossOrigin
	@ResponseBody
	@RequestMapping(value = "/getInterviewDetails", method = RequestMethod.GET)
	public List<Candidate> getInterviewDetails() {

		String hql = "FROM Candidate as can";
		List<Candidate> ls = new ArrayList<>();
		ls = entityManager.createQuery(hql).getResultList();
		System.out.println("result size : " + ls.size());

		return ls;

	}
	
	@CrossOrigin
	@RequestMapping(value = "/candidateSearch", method = RequestMethod.GET)
	@ResponseBody
	public List<Candidate> searchCandidate(@RequestParam("panCard") String panCard,
			@RequestParam("emailID") String emailID,@RequestParam("status") String status,@RequestParam("start") String startDate,@RequestParam("end") String endDate ) {

		List<Candidate> can = new ArrayList<>();

		can=candidateService.searchCandidate(panCard,emailID,status,startDate,endDate);
		return can;

	}

}

package com.idemia.HiringProject.validators;



import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;


import com.idemia.HiringProject.DAO.CandidateDAO;

public class UniquePanNumberValidator implements ConstraintValidator<UniquePanNumber, String> {

	@Autowired
	private  CandidateDAO candidatedao;

	@Override
	public void initialize(UniquePanNumber constraintAnnotation) {

	}

	@Override
	public boolean isValid(String candidate_id, ConstraintValidatorContext context) {
		if (candidatedao == null) {
			return true;
		}
		return candidatedao.getCandidateByPanNumber(candidate_id) == null;
	}

}

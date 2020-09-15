package com.jeipz.pma.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.jeipz.pma.dao.EmployeeRepository;
import com.jeipz.pma.entities.Employee;

public class UniqueValidator implements ConstraintValidator<UniqueValue, String>{

	@Autowired
	EmployeeRepository empRepo;
	
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		System.out.println("Entered validation method..");
		Employee employee = empRepo.findByEmail(value);
		return (employee != null) ? false : true;
	}
	
}

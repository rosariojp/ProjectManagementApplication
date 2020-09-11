package com.jeipz.pma.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jeipz.pma.dao.EmployeeRepository;
import com.jeipz.pma.dto.EmployeeProject;
import com.jeipz.pma.entities.Employee;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository empRepo;
	
	public Employee save(Employee employee) {
		return empRepo.save(employee);
	}

	public List<Employee> getAll() {
		return empRepo.findAll();
	}
	
	public List<EmployeeProject> getEmployeeProjects() {
		return empRepo.getEmployeeProjects();
	}
	
}

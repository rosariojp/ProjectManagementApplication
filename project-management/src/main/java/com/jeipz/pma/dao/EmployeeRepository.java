package com.jeipz.pma.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.jeipz.pma.dto.EmployeeProject;
import com.jeipz.pma.entities.Employee;

@RepositoryRestResource(collectionResourceRel = "apiemployees", path = "apiemployees")
public interface EmployeeRepository extends PagingAndSortingRepository<Employee, Long> {

	@Override
	public List<Employee> findAll();

	@Query(nativeQuery = true, value = "SELECT e.first_name AS firstName, e.last_name AS lastName, COUNT(pe.employee_id) As projectCount " + 
			"FROM employee e LEFT JOIN project_employee pe ON pe.employee_id = e.employee_id " + 
			"GROUP BY e.first_name, e.last_name ORDER BY 3 DESC")
	public List<EmployeeProject> getEmployeeProjects();

	public Employee findByEmail(String value);

	public Employee findByEmployeeId(long id);
	
}

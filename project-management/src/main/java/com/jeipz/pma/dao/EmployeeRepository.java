package com.jeipz.pma.dao;

import org.springframework.data.repository.CrudRepository;

import com.jeipz.pma.entities.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {

}

package com.websystique.springmvc.service;

import java.util.List;

import com.websystique.springmvc.model.Employee;

public interface EmployeeService {

	Employee findById(int id);

	Employee findBySsn(String ssn);
	
	List<Employee> findAllEmployees();

	void saveEmployee(Employee employee);
	
	void updateEmployee(Employee employee);
	
	void deleteEmployeeBySsn(String ssn);
	
	boolean isEmployeeSsnUnique(Integer id, String ssn);
}

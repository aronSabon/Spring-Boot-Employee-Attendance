package com.lemon.service;

import java.util.List;

import com.lemon.model.Employee;

public interface EmployeeService {
	
	void addEmp(Employee emp);
	void deleteEmp(int id);
	
	void updateEmp(Employee emp);
	Employee getEmpById(int id);
	List<Employee> getAllEmps();
	
	
	

}

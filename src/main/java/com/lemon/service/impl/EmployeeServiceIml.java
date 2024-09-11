package com.lemon.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lemon.model.Employee;
import com.lemon.repository.EmployeeRepository;
import com.lemon.service.EmployeeService;
@Service
public class EmployeeServiceIml  implements EmployeeService {
     @Autowired
	private EmployeeRepository empRepo;
     

	@Override
	public void addEmp(Employee emp) {
		
		empRepo.save(emp);
	}

	@Override
	public void deleteEmp(int id) {
		empRepo.deleteById(id);
		
	}

	@Override
	public void updateEmp(Employee emp) {
		empRepo.save(emp);
		
	}

	@Override
	public Employee getEmpById(int id) {
		
		
		return empRepo.findById(id).get();
	}

	@Override
	public List<Employee> getAllEmps() {
		
		return empRepo.findAll();
	}
	

}

package com.lemon.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lemon.model.Department;
import com.lemon.repository.DepartmentRepository;
import com.lemon.service.DepartmentService;
@Service
public class DepartmentServiceImpl implements DepartmentService {
    
	@Autowired
	private DepartmentRepository deptRepo;
	
	
	@Override
	public void addDept(Department dept) {
		deptRepo.save(dept);
		
	}

	@Override
	public void deleteDept(int dptId) {
		deptRepo.deleteById(dptId);
		
		
	}

	@Override
	public void updateDept(Department dept) {
		deptRepo.save(dept);
				
	}

	@Override
	public List<Department> getAllDept() {
		
		return deptRepo.findAll();
	}

	@Override
	public Department getDeptById(int deptId) {
		
		return deptRepo.findById(deptId).get();
	}

}

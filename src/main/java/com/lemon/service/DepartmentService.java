package com.lemon.service;

import java.util.List;

import com.lemon.model.Department;

public interface DepartmentService {
	
	void addDept(Department dept);
	void deleteDept(int dptId);
	void updateDept(Department dept);
	List<Department> getAllDept();
	Department getDeptById(int deptId);
	
	
	

}

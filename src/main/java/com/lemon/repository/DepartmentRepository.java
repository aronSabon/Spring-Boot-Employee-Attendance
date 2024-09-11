package com.lemon.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lemon.model.Department;

public interface DepartmentRepository extends JpaRepository<Department, Integer> 

{
	

}

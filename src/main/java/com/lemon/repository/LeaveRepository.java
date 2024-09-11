package com.lemon.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lemon.model.Leave;

public interface LeaveRepository extends JpaRepository<Leave, Integer>{
	List<Leave> findByFirstNameAndLastName(String firstName,String lastName);
}

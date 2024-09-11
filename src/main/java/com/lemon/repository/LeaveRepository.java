package com.lemon.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.lemon.model.AttendanceApprove;
import com.lemon.model.Leave;

public interface LeaveRepository extends JpaRepository<Leave, Integer>{
	List<Leave> findByFirstNameAndLastName(String firstName,String lastName);
	
	@Query ("SELECT a FROM Leave a WHERE a.firstName like %?1% OR a.lastName like %?1%")
	List<Leave> findByText(String sData);
}

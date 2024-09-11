package com.lemon.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.lemon.model.Leave;
import com.lemon.model.LeaveApprove;

public interface LeaveApproveRepository extends JpaRepository<LeaveApprove, Integer>{
	List<LeaveApprove> findByFirstNameAndLastName(String firstName,String lastName);
	@Query ("SELECT a FROM LeaveApprove a WHERE a.firstName like %?1% OR a.lastName like %?1%")
	List<LeaveApprove> findByText(String sData);
}

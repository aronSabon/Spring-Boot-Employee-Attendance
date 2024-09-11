package com.lemon.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lemon.model.Leave;
import com.lemon.model.LeaveApprove;

public interface LeaveApproveRepository extends JpaRepository<LeaveApprove, Integer>{
	List<LeaveApprove> findByFirstNameAndLastName(String firstName,String lastName);

}

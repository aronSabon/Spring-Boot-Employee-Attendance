package com.lemon.service;

import java.time.LocalDate;
import java.util.List;

import com.lemon.model.Leave;
import com.lemon.model.User;

public interface LeaveService {

	
	void addLeave(Leave leave);
	void deleteLeaveById(int id);
	void updateLeave(Leave leave);
	List<Leave> getAllLeave();
	Leave getLeaveById(int id);
	List<Leave> getAllLeaveByFullName(String firstName, String lastName);
	
}

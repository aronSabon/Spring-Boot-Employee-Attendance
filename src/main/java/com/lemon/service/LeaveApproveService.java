package com.lemon.service;

import java.util.List;

import com.lemon.model.Leave;
import com.lemon.model.LeaveApprove;

public interface LeaveApproveService {

	
	void addLeaveApprove(LeaveApprove leaveApprove);
	void deleteLeaveApproveById(int id);
	void updateLeaveApprove(LeaveApprove leaveApprove);
	List<LeaveApprove> getAllLeaveApprove();
	List<LeaveApprove> getAllLeaveByFullName(String firstName, String lastName);

	
}

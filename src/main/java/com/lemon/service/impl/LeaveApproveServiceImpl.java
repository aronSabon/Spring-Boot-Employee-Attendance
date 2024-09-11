package com.lemon.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lemon.model.LeaveApprove;
import com.lemon.repository.LeaveApproveRepository;
import com.lemon.service.LeaveApproveService;
@Service
public class LeaveApproveServiceImpl implements LeaveApproveService{
	@Autowired
	LeaveApproveRepository leaveApproveRepository;

	@Override
	public void addLeaveApprove(LeaveApprove leaveApprove) {
		// TODO Auto-generated method stub
		leaveApproveRepository.save(leaveApprove);
	}

	@Override
	public void deleteLeaveApproveById(int id) {
		// TODO Auto-generated method stub
		leaveApproveRepository.deleteById(id);
	}

	@Override
	public void updateLeaveApprove(LeaveApprove leaveApprove) {
		// TODO Auto-generated method stub
		leaveApproveRepository.save(leaveApprove);
	}

	@Override
	public List<LeaveApprove> getAllLeaveApprove() {
		// TODO Auto-generated method stub
		return leaveApproveRepository.findAll();
	}

	@Override
	public List<LeaveApprove> getAllLeaveByFullName(String firstName, String lastName) {
		// TODO Auto-generated method stub
		return leaveApproveRepository.findByFirstNameAndLastName(firstName, lastName);
	}

	@Override
	public List<LeaveApprove> getAllLeaveBySearch(String sData) {
		// TODO Auto-generated method stub
		return leaveApproveRepository.findByText(sData);
	}

}

package com.lemon.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lemon.model.Leave;
import com.lemon.repository.LeaveRepository;
import com.lemon.service.LeaveService;
@Service
public class LeaveServiceImpl implements LeaveService{
	@Autowired
	LeaveRepository leaveRepository;

	@Override
	public void addLeave(Leave leave) {
		// TODO Auto-generated method stub
		leaveRepository.save(leave);
	}

	@Override
	public void deleteLeaveById(int id) {
		// TODO Auto-generated method stub
		leaveRepository.deleteById(id);
	}

	@Override
	public void updateLeave(Leave leave) {
		// TODO Auto-generated method stub
		leaveRepository.save(leave);
	}

	@Override
	public List<Leave> getAllLeave() {
		// TODO Auto-generated method stub
		return leaveRepository.findAll();
	}

	@Override
	public Leave getLeaveById(int id) {
		// TODO Auto-generated method stub
		return leaveRepository.findById(id).get();
	}

	@Override
	public List<Leave> getAllLeaveByFullName(String firstName, String lastName) {
		// TODO Auto-generated method stub
		return leaveRepository.findByFirstNameAndLastName(firstName, lastName);
	}

}

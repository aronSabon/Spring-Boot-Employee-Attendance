package com.lemon.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lemon.model.Attendance;
import com.lemon.model.AttendanceApprove;
import com.lemon.repository.AttendanceAppRepository;
import com.lemon.repository.AttendanceRepository;
import com.lemon.service.AttendanceAppService;
@Service
public class AttendanceAppServiceImpl implements AttendanceAppService {

	  @Autowired
		private AttendanceAppRepository attRepo;
	
	@Override
	public void addAttendance(AttendanceApprove atta) {
		attRepo.save(atta);
		
	}

	@Override
	public void deleteAttendanceById(int attaId) {
		attRepo.deleteById(attaId);
	}

	@Override
	public void updateDept(AttendanceApprove atta) {
		attRepo.save(atta);
	}

	@Override
	public List<AttendanceApprove> getAllAttendance() {
		
		return attRepo.findAll();
	}

	@Override
	public AttendanceApprove getAttendanceById(int attaId) {
		
		return attRepo.findById(attaId).get();
	}


	

}

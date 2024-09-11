package com.lemon.service.impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lemon.model.Attendance;
import com.lemon.model.Department;
import com.lemon.repository.AttendanceRepository;
import com.lemon.service.AttendanceService;
@Service
public class AttendanceServiceImpl implements AttendanceService {
    @Autowired
	private AttendanceRepository attRepo;
	
	
	
	
	@Override
	public void addAttendance(Attendance att) {
	     
		attRepo.save(att);
	}

	@Override
	public void deleteAttendanceById(int attId) {
	     
		attRepo.deleteById(attId);
		
	}

	@Override
	public void updateDept(Attendance att) {
		attRepo.save(att);
		
	}

	@Override
	public List<Attendance> getAllAttendance() {
		
		return attRepo.findAll();
	}

	@Override
	public Attendance getAttendanceById(int attId) {
		
		return attRepo.findById(attId).get();
	}

	@Override
	public Attendance getAttendanceByDateAndFaname(LocalDate date, String faname) {
		// TODO Auto-generated method stub
		return attRepo.findByDateAndFaname(date, faname);
	}

	@Override
	public List<Attendance> getAttendanceByName(String faname) {
		// TODO Auto-generated method stub
		return attRepo.findByFaname(faname);
	}



	
	

}

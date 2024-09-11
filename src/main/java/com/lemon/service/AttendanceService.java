package com.lemon.service;

import java.time.LocalDate;
import java.util.List;

import com.lemon.model.Attendance;
import com.lemon.model.Department;

public interface AttendanceService {

	void addAttendance(Attendance att);
	void deleteAttendanceById(int attId);
	void updateDept(Attendance att);
	List<Attendance> getAllAttendance();
	Attendance getAttendanceById(int attId);
	Attendance getAttendanceByDateAndFaname(LocalDate date, String faname);
	List<Attendance> getAttendanceByName(String faname);

	
}

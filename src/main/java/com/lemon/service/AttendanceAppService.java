package com.lemon.service;

import java.util.List;

import com.lemon.model.Attendance;
import com.lemon.model.AttendanceApprove;

public interface AttendanceAppService {
	
	
	void addAttendance(AttendanceApprove atta);
	void deleteAttendanceById(int attaId);
	void updateDept(AttendanceApprove atta);
	List<AttendanceApprove> getAllAttendance();
	AttendanceApprove getAttendanceById(int attaId);

}

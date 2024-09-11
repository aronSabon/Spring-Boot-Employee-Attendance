package com.lemon.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.lemon.model.Attendance;
import com.lemon.model.AttendanceApprove;

public interface AttendanceAppRepository extends JpaRepository<AttendanceApprove, Integer>{
	
	
	@Query ("SELECT a FROM AttendanceApprove a WHERE a.faname like %?1% OR a.laname like %?1%")
	List<AttendanceApprove> findByText(String sData);
	
	@Query ("SELECT a FROM AttendanceApprove a WHERE a.date = ?1")
	List<AttendanceApprove> findByDate(LocalDate sData);

}

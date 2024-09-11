package com.lemon.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.lemon.model.Attendance;

public interface AttendanceRepository extends JpaRepository<Attendance, Integer> {
	
	@Query ("SELECT a FROM Attendance a WHERE a.faname like %?1% OR a.laname like %?1%")
	List<Attendance> findByText(String sData);
	
	@Query ("SELECT a FROM Attendance a WHERE a.date = ?1")
	List<Attendance> findByDate(LocalDate sData);
	
	Attendance findByDateAndFaname(LocalDate date,String faname);
	
	List<Attendance> findByFaname(String faname);

}

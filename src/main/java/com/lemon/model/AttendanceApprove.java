package com.lemon.model;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
@Entity
@Data
public class AttendanceApprove {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
   private int id;
   private String faname;
   private String laname;
 
   private String checkin;
   private String checkout; 
   @DateTimeFormat(iso = ISO.DATE)
   private LocalDate date;
   


}

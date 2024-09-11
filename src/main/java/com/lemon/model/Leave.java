package com.lemon.model;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
@Entity
@Data
@Table(name = "leavetbl")
public class Leave {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String firstName;
	private String lastName;
	private String type;
	private String remarks;
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate startDate;
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate endDate;

}

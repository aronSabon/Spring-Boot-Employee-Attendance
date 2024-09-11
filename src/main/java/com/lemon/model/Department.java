package com.lemon.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="department_tbl")
public class Department {
     
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int dpt_id;
	private String dpt_name;
	private String dpt_phone;
	private String dpt_hod;
	public int getDpt_id() {
		return dpt_id;
	}
	public void setDpt_id(int dpt_id) {
		this.dpt_id = dpt_id;
	}
	public String getDpt_name() {
		return dpt_name;
	}
	public void setDpt_name(String dpt_name) {
		this.dpt_name = dpt_name;
	}
	public String getDpt_phone() {
		return dpt_phone;
	}
	public void setDpt_phone(String dpt_phone) {
		this.dpt_phone = dpt_phone;
	}
	public String getDpt_hod() {
		return dpt_hod;
	}
	public void setDpt_hod(String dpt_hod) {
		this.dpt_hod = dpt_hod;
	}
	
	
}

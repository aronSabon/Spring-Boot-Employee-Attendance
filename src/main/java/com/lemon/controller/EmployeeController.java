package com.lemon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.lemon.model.Employee;
import com.lemon.service.DepartmentService;
import com.lemon.service.EmployeeService;

@Controller
public class EmployeeController {
	@Autowired
	private EmployeeService empService;
	@Autowired
	private DepartmentService deptService;
	
    @GetMapping("/employee")
	public String getEmployee(Model model) {
		
		model.addAttribute("dList",deptService.getAllDept());
		return "EmployeeForm";
	}
	@PostMapping("/employee")
	public String postEmployee( @ModelAttribute Employee emp) {
		empService.addEmp(emp);
		
		return " redirect:/employee";
	}
	
}

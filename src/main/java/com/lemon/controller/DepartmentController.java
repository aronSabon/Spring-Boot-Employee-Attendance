package com.lemon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lemon.model.Department;
import com.lemon.service.DepartmentService;

@Controller
public class DepartmentController {
	
	
	@Autowired
	private DepartmentService deptService;
	
	
	@GetMapping("/department")
   public  String getDeptForm() {
	   return "DepartmentForm";
   }
	
   @PostMapping("/department")
	public String postDept(@ModelAttribute Department dept) {
	   
	   deptService.addDept(dept);
		return "DepartmentForm";
	}
   
  @GetMapping("/departmentList")  
   public String getDptList(Model model) {
	  
	  
	  
	  model.addAttribute("dList",deptService.getAllDept());
	   return "DepartmentListForm";
	
   }
  
  
  @GetMapping("/dept/delete")
  public String delete(@RequestParam int id) {
	  
	  
	  deptService.deleteDept(id);
	  return "redirect:/departmentList";
  }
  
  @GetMapping("/dept/edit")
  public String edit(@RequestParam int id,Model model) {
	  
	  model.addAttribute("dModel", deptService.getDeptById(id));
	  
	  return "DepartmentEditForm";
	  	
  }

  @PostMapping("/dept/update")
  public String update(@ModelAttribute Department dept) {
	  
	  deptService.updateDept(dept);
	  return "redirect:/departmentList";
  }
  
}

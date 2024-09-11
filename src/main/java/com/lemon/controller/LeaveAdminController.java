package com.lemon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lemon.model.Leave;
import com.lemon.model.LeaveApprove;
import com.lemon.service.LeaveApproveService;
import com.lemon.service.LeaveService;


@Controller
public class LeaveAdminController {
	@Autowired
	LeaveService leaveService;
	@Autowired
	LeaveApproveService leaveApproveService;
	
	
	@GetMapping("/leaveAdmin")
	private String getLeave(Model model) {
		model.addAttribute("lList" ,leaveService.getAllLeave());
		model.addAttribute("laList" , leaveApproveService.getAllLeaveApprove());
		return "LeaveAdmin";
	}
	@GetMapping("/acceptLeave")
	private String accLeave(@RequestParam int id) {
		Leave leave= leaveService.getLeaveById(id);
		LeaveApprove leaveApprove = new LeaveApprove();
		leaveApprove.setEndDate(leave.getEndDate());
		leaveApprove.setFirstName(leave.getFirstName());
		leaveApprove.setLastName(leave.getLastName());
		leaveApprove.setRemarks(leave.getRemarks());
		leaveApprove.setStartDate(leave.getStartDate());
		leaveApprove.setType(leave.getType());
		leaveApprove.setStatus("Approved");
		leaveApproveService.addLeaveApprove(leaveApprove);
		leaveService.deleteLeaveById(id);
		return "redirect:/leaveAdmin";
	}
	@GetMapping("/rejectLeave")
	private String rejectLeave(@RequestParam int id) {
		Leave leave= leaveService.getLeaveById(id);
		LeaveApprove leaveApprove = new LeaveApprove();
		leaveApprove.setEndDate(leave.getEndDate());
		leaveApprove.setFirstName(leave.getFirstName());
		leaveApprove.setLastName(leave.getLastName());
		leaveApprove.setRemarks(leave.getRemarks());
		leaveApprove.setStartDate(leave.getStartDate());
		leaveApprove.setType(leave.getType());
		leaveApprove.setStatus("Declined");
		leaveApproveService.addLeaveApprove(leaveApprove);
		leaveService.deleteLeaveById(id);
		return "redirect:/leaveAdmin";
	}
	
}

package com.lemon.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.lemon.model.Leave;
import com.lemon.model.LeaveApprove;
import com.lemon.model.User;
import com.lemon.service.LeaveApproveService;
import com.lemon.service.LeaveService;
import com.lemon.service.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class LeaveController {
	@Autowired
	LeaveService leaveService;
	@Autowired
	UserService userService;
	@Autowired
	LeaveApproveService leaveApproveService;

	@GetMapping("/leave")
	private String getLeave(Model model,HttpSession session) {
		User u = (User)session.getAttribute("validUser");
		User user = userService.getbyEmail(u.getEmail());
		List<Leave>lList= leaveService.getAllLeaveByFullName(user.getFname(), user.getLname());
		model.addAttribute("lList",lList);
		List<LeaveApprove>laList= leaveApproveService.getAllLeaveByFullName(user.getFname(), user.getLname());

		model.addAttribute("laList",laList);
		
		return "Leave";
	}
	@PostMapping("/leave")
	private String postLeave(@ModelAttribute Leave leave,HttpSession session) {
		if(session.getAttribute("validUser")==null) {
			return "LoginForm";
		}
		else {
		User u=(User)session.getAttribute("validUser");
		User user = userService.getbyEmail(u.getEmail());
		leave.setFirstName(user.getFname());
		leave.setLastName(user.getLname());
		leaveService.addLeave(leave);
		return "redirect:/leave";
		}
	}
}

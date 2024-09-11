package com.lemon.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lemon.model.Attendance;
import com.lemon.model.AttendanceApprove;
import com.lemon.repository.AttendanceAppRepository;
import com.lemon.repository.AttendanceRepository;
import com.lemon.service.AttendanceAppService;
import com.lemon.service.AttendanceService;

@Controller
public class AdminAttendanceController {
	@Autowired
	AttendanceAppService attAppService;
	@Autowired
	AttendanceService attService;
	@Autowired
	AttendanceRepository ar;
	@Autowired
	AttendanceAppRepository aar;
	
	
	@GetMapping("/attendanceAdmin")
	public String getattadmin(Model model) {
		model.addAttribute("aModel",attService.getAllAttendance());
//		model.addAttribute("approvedModel", attAppService.getAllAttendance());
		return "AttendanceAdmin";
		
	}
	
	
//	@GetMapping("/acceptAttendance")
//	private String acceptAtt(@RequestParam int id) {
//		Attendance att = attService.getAttendanceById(id);
//		attService.deleteAttendanceById(id);
//		AttendanceApprove attApprove= new AttendanceApprove();
//		attApprove.setFaname(att.getFaname());
//		attApprove.setLaname(att.getLaname());
//		attApprove.setCheckin(att.getCheckin());
//		attApprove.setCheckout(att.getCheckout());
//		attApprove.setDate(att.getDate());
//		attAppService.addAttendance(attApprove);
//		return "redirect:/attendanceAdmin";
//	}
//	@GetMapping("/rejectAttendance")
//	private String reject(@RequestParam int id) {
//		attService.deleteAttendanceById(id);
//		return "redirect:/attendanceAdmin";
//
//	}
	
	@PostMapping("/search")
	public String search(Model model,@RequestParam String search) {
		
		List<Attendance>aList=ar.findByText(search);
		model.addAttribute("aModel",aList);
//		List<AttendanceApprove>apprList=aar.findByText(search);
//		model.addAttribute("approvedModel",apprList);

		return "AttendanceAdmin";
		
	}
	@PostMapping("/searchDate")
	public String searchDate(Model model,@RequestParam(required = false)LocalDate search) {
		if(search==null) {
			return "redirect:/attendanceAdmin";
		}
		else {
		List<Attendance>aList=ar.findByDate(search);
		model.addAttribute("aModel",aList);
//		
//		List<AttendanceApprove>apprList=aar.findByDate(search);
//		model.addAttribute("approvedModel",apprList);


		return "AttendanceAdmin";
		}
		
	}
}

package com.lemon.controller;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lemon.model.Attendance;
import com.lemon.model.Department;
import com.lemon.model.User;
import com.lemon.service.AttendanceService;
import com.lemon.service.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class AttendanceController {
	@Autowired
	private AttendanceService attService;
	@Autowired
	private UserService userService;

	@GetMapping("/attendance")
	public String getAttForm(Model model,HttpSession session) {
		User u = (User) session.getAttribute("validUser");
		User user = userService.getbyEmail(u.getEmail());
		List<Attendance> aList= attService.getAttendanceByName(user.getFname());
		model.addAttribute("attendanceList",aList);
		return "Attendance";

	}

//	@PostMapping("/attendance")
//	public String postAtt(@ModelAttribute Attendance att) {
//		
//		attService.addAttendance(att);
//		return "Attendance";
//	    
//	}
	@GetMapping("/punchIn")
	public String punvhIN(HttpSession session) {
		if (session.getAttribute("validUser") == (null)) {
			return "LoginForm";
		} else {
			User u = (User) session.getAttribute("validUser");
			User user = userService.getbyEmail(u.getEmail());
			Attendance attendance = attService.getAttendanceByDateAndFaname(LocalDate.now(), user.getFname());
			// if there is lready user data
			if (attendance != null) {
				Attendance att = new Attendance();
				att.setFaname(attendance.getFaname());
				att.setLaname(attendance.getLaname());
				att.setCheckout(attendance.getCheckout());
				att.setCheckin(LocalTime.now());
				att.setDate(attendance.getDate());
				att.setId(attendance.getId());
				attService.addAttendance(att);
				return "redirect:/attendance";
			}
			// if no data
			else {
				Attendance att = new Attendance();
				att.setFaname(user.getFname());
				att.setLaname(user.getLname());
				att.setCheckin(LocalTime.now());
				att.setDate(LocalDate.now());
				attService.addAttendance(att);

				return "redirect:/attendance";
			}
		}
	}

	@GetMapping("/punchOut")
	public String punvhOut(HttpSession session) {
		if (session.getAttribute("validUser") == (null)) {
			return "LoginForm";
		} else {
			User u = (User) session.getAttribute("validUser");
			User user = userService.getbyEmail(u.getEmail());
			Attendance attendance = attService.getAttendanceByDateAndFaname(LocalDate.now(), user.getFname());
			// if there is lready user data
			if (attendance != null) {
				Attendance att = new Attendance();
				att.setFaname(attendance.getFaname());
				att.setLaname(attendance.getLaname());
				att.setCheckin(attendance.getCheckin());
				att.setDate(attendance.getDate());
				att.setCheckout(LocalTime.now());
				att.setId(attendance.getId());
				attService.addAttendance(att);
				return "redirect:/attendance";
			} 
			// if no data
			else{
				Attendance att = new Attendance();
				att.setFaname(user.getFname());
				att.setLaname(user.getLname());
				att.setCheckout(LocalTime.now());
				att.setDate(LocalDate.now());
				attService.addAttendance(att);

				return "redirect:/attendance";
			}
		}
	}

	@GetMapping("/attendanceList")
	public String getAttList(Model model) {

		model.addAttribute("aList", attService.getAllAttendance());
		return "attendanceListForm";

	}

	@GetMapping("/att/delete")
	public String delete(@RequestParam int id) {

		attService.deleteAttendanceById(id);
		return "redirect:/attendanceList";
	}

	@GetMapping("/att/edit")
	public String edit(@RequestParam int id, Model model) {

		model.addAttribute("aModel", attService.getAttendanceById(id));

		return "attendanceEditForm";

	}

	@PostMapping("/att/update")
	public String update(@ModelAttribute Attendance att) {

		attService.updateDept(att);
		return "redirect:/attendanceList";
	}

}

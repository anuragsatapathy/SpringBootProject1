package com.boot.employee.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.boot.employee.model.Employee;

@Controller
@RequestMapping("/app")
public class EmployeeWebController {

	@GetMapping("/home")
	public String doHome(Model m) {
		
		m.addAttribute("name", "springboot app");
		
		return "home";
	}
	
	@GetMapping("/addemp")
	public String addEmployee(Model m) {
		m.addAttribute("employee", new Employee());
		return "employee";
		
	}
	
	
	
}

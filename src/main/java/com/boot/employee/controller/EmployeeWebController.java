package com.boot.employee.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.boot.employee.model.Employee;
import com.boot.employee.repository.EmployeeRepository;

@Controller
@RequestMapping("/app")
public class EmployeeWebController {

	@Autowired
	private EmployeeRepository repository;
	
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
	
	@GetMapping("/listemp")
	public String getAllEmployee(Model m) {
		List<Employee> list = repository.findAll();
		m.addAttribute("employees", list);
		return "getallemp";
		
	}
	
	@GetMapping("/getemp/{id}")
	public String getEmp(@PathVariable Integer id, Model m) {
		Optional<Employee> empoptional = repository.findById(id);
		if(empoptional.isPresent()) {
			Employee emp = empoptional.get();
			m.addAttribute("employee", emp);
			return "getemp";
		}
		else {
			m.addAttribute("message", "employee not found");
			return "error";
		}
		
		
	}
	
	@PostMapping("/updateemp")
	public String updateEmployee(Employee employee) {
		repository.save(employee);
		return "redirect:/app/listemp";
	
	}
	
	@GetMapping("/deleteemp/{id}")
	public String deleteEmployee(@PathVariable Integer id) {
		repository.deleteById(id);
		return "redirect:/app/listemp";
		
		
	}
	
	
	
}

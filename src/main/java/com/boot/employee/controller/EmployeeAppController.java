package com.boot.employee.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boot.employee.model.Employee;
import com.boot.employee.repository.EmployeeRepository;

@Controller
@RequestMapping("/Emp")
public class EmployeeAppController {

	@Autowired
	private EmployeeRepository repository;
	
	
	//@PostMapping("/saveemp")
	@PostMapping
	public String addEmployee(Employee employee) {
		repository.save(employee);
		return "redirect:/app/listemp";
		
	}
	
	
}

package com.boot.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boot.employee.model.Employee;
import com.boot.employee.repository.EmployeeRepository;

@RestController
@RequestMapping("/Employees")
public class EmployeeController {

	@Autowired
	private EmployeeRepository repository;
	
	//get all employees
	@GetMapping
	public List<Employee> getAllEmployees(){
		
		return repository.findAll();
		
	}
	
	//add an Employee
	
	@PostMapping
	public Employee addEmployee(@RequestBody Employee employee) {
		return repository.save(employee);
		
	}
}

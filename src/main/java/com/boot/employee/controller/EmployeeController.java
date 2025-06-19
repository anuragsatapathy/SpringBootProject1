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

//@RestController
@Controller
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
	
	/*
	 * @PostMapping public Employee addEmployee(@RequestBody Employee employee) {
	 * return repository.save(employee);
	 * 
	 * }
	 */
	
	//@PostMapping("/saveemp")
	@PostMapping
	public String addEmployee(Employee employee) {
		repository.save(employee);
		return "redirect:/app/home";
		
	}
	
	//get employee by id
	
	@GetMapping("/{id}")
	public Optional<Employee> getEmployee(@PathVariable Integer id){
		return repository.findById(id);
		
	}
	
	//update student by id 
	
	@PutMapping("/{id}")
	public Employee updateEmployee(@PathVariable Integer id, @RequestBody Employee Employeedetails) {
		Employee employee = repository.findById(id).orElseThrow();
		employee.setName(Employeedetails.getName());
		employee.setEmail(Employeedetails.getEmail());
		return repository.save(employee);
		
	}
	
	//delete student by id 
	@DeleteMapping("/{id}")
	public void deleteEmployee(@PathVariable Integer id) {
		repository.deleteById(id);
	}
}

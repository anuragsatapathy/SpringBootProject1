package com.boot.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.boot.employee.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}

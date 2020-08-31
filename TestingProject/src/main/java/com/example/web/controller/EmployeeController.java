package com.example.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.web.entity.Employee;
import com.example.web.service.EmployeeService;

@Controller
public class EmployeeController {
	
	@Autowired
	private EmployeeService empService;
	
	@RequestMapping("/")
	public String welcome() {
	 
	    return "welcome";
	}
	
	//Retrieve Method for all employee
	@GetMapping("/employees")
	public List<Employee> list() {
	    return empService.listAll();
	}

	//Update Method for employee
	@PutMapping("/products/{id}")
	public Employee update(@RequestBody Employee employee, @PathVariable Integer id) {
	 
	        Employee exitEmployee= empService.get(id);
	        empService.save(employee);  
	    return exitEmployee;
	}
	
	//Save Method For Employee
	@PostMapping("/employee")
	public void add(@RequestBody Employee employee) {
		empService.save(employee);
	}
	
	//Delete Method For Employee
	@DeleteMapping("/employee/{id}")
	public void delete(@PathVariable Integer id) {
		empService.delete(id);
	}
	
	//Retrieve Method for id employee
	@GetMapping("/employee/{id}")
	public Employee get(@PathVariable Integer id) {
	    
	        Employee employee = empService.get(id);
	        return employee;
	           
	}
}

package com.project.saksoft.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.saksoft.entity.Employee;
import com.project.saksoft.service.EmployeeService;

/**
 * @author vinayak
 * @param employee
 * @return Employee object
 * Date: 13-083-2023
 */
@RestController
public class EmployeeController {
	@Autowired
	private EmployeeService service;
	
	
	// add Employee
	@PostMapping("/addEmployee")
	public Employee addEmployee(@RequestBody Employee employee){
		return service.saveEmployee(employee);
	}
	@GetMapping("/getAllEmployee")
	public List<Employee> getAllEmployee(){
		return service.getEmployees();	
	}
	@GetMapping("/getEmployeeById/{id}")
	public Employee getEmployeeById(@PathVariable int id){
		return service.employeeById(id);	
	}
	@PutMapping("/updateEmployee")
	public String updateEmpoyees(@RequestBody Employee employee){
		return service.updateEmployee(employee);
		
	}
	@DeleteMapping("/deleteEmployee/{id}")
	public String deleteEmployeeById(@PathVariable int id){
		return service.deleteEmployee(id);
	}

}

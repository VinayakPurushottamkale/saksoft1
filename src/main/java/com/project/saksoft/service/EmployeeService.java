package com.project.saksoft.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.condition.ProducesRequestCondition;

import com.project.saksoft.entity.Employee;
import com.project.saksoft.repository.EmployeeRepository;

@Service
public class EmployeeService {
	@Autowired	
	private EmployeeRepository repository;
	
	public Employee saveEmployee(Employee employee){
		return repository.save(employee);
		
	}
	public List<Employee> getEmployees(){
		return repository.findAll();
	}
	public Employee employeeById(int id){
		return repository.findById(id).orElse(null);
		
	}
	public String updateEmployee(Employee employee){
		Employee existingEmployee=repository.findById(employee.getId()).orElse(null);
		existingEmployee.setFirstName(employee.getFirstName());
		existingEmployee.setLastName(employee.getLastName());
		existingEmployee.setEmail(employee.getEmail());
		existingEmployee.setAge(employee.getAge());
		 repository.save(existingEmployee);
		return "Employee Data Updated Sucessfully: ";
	}
	public String deleteEmployee(int id){
		 repository.deleteById(id);
		 return "Employee data Deleted Successfully..! " +id;
	}
}

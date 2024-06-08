package com.openeye.employee.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.openeye.employee.dto.ResponseMessage;
import com.openeye.employee.model.Employee;
import com.openeye.employee.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping
	public ResponseEntity<ResponseMessage> addEmployee(@RequestBody Employee employee){
		employeeService.addEmployee(employee);
		ResponseMessage responseMessage = new ResponseMessage();
		responseMessage.setMesssage("Employee added successfully");
		responseMessage.setTimestamp(LocalDateTime.now());
		return new ResponseEntity<>(responseMessage, HttpStatus.CREATED);
		
	}
	
	@GetMapping("/{employeeId}")
	public ResponseEntity<Employee> getEmployee(@PathVariable("employeeId") Long employeeId){
		try {
			System.out.println("going for wail of 5s" + Thread.currentThread().getName());
			Thread.currentThread().wait(5000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Employee employee = employeeService.getEmployee(employeeId);
		return new ResponseEntity<>(employee, HttpStatus.OK);
		
	}
	
	@GetMapping
	public ResponseEntity<List<Employee>> getEmployees(){
		List<Employee> employees = employeeService.getEmployees();
		return new ResponseEntity<>(employees, HttpStatus.OK);
		
	}
}

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
	public ResponseEntity<ResponseMessage> addEmployee(@RequestBody Employee employee) {
		ResponseMessage responseMessage = new ResponseMessage();
		if (employee.getEmployeerAssociateId() == null || employee.getFirstName() == null
				|| employee.getLastName() == null || employee.getGender() == null || employee.getAge() == 0) {
			responseMessage = new ResponseMessage();
			responseMessage.setMesssage("Request is invalid");
			responseMessage.setTimestamp(LocalDateTime.now());
			return new ResponseEntity<>(responseMessage, HttpStatus.BAD_REQUEST);
		}
		employeeService.addEmployee(employee);
		
		responseMessage.setMesssage("Employee added successfully");
		responseMessage.setTimestamp(LocalDateTime.now());
		return new ResponseEntity<>(responseMessage, HttpStatus.CREATED);

	}

	@GetMapping("/{employeeId}")
	public ResponseEntity<Employee> getEmployee(@PathVariable("employeeId") Long employeeId) {
		Employee employee = employeeService.getEmployee(employeeId);
		return new ResponseEntity<>(employee, HttpStatus.OK);

	}

	@GetMapping
	public ResponseEntity<List<Employee>> getEmployees() {
		List<Employee> employees = employeeService.getEmployees();
		return new ResponseEntity<>(employees, HttpStatus.OK);

	}
}

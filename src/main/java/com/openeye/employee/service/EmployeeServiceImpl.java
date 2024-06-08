package com.openeye.employee.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.openeye.employee.model.Employee;
import com.openeye.employee.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	Environment environment;
	@Override
	public void addEmployee(Employee employee) {
		employeeRepository.save(employee);
	}

	@Override
	public Employee getEmployee(Long employeeId) {
		String portNumber = environment.getProperty("server.port");
		System.out.println("Port number of employee service ==>"+ portNumber);
		Optional<Employee> employeeOptional = employeeRepository.findById(employeeId);
		if(employeeOptional.isPresent()) {
			return employeeOptional.get();
		}
		return null;
	}

	@Override
	public List<Employee> getEmployees() {
		List<Employee> findAll = employeeRepository.findAll();
		return findAll;
	}

}

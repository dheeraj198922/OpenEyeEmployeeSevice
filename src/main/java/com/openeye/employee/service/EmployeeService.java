package com.openeye.employee.service;

import java.util.List;

import com.openeye.employee.model.Employee;

public interface EmployeeService {

	void addEmployee(Employee employee);

	Employee getEmployee(Long employeeId);

	List<Employee> getEmployees();

}

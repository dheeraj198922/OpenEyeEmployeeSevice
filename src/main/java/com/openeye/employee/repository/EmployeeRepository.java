package com.openeye.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.openeye.employee.model.Employee;


public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}

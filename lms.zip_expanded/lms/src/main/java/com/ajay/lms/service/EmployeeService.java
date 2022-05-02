package com.ajay.lms.service;

import java.util.List;

import com.ajay.lms.pojo.Employee;
import com.ajay.lms.pojo.MockRatings;

public interface EmployeeService {
	
	public Employee addEmployee(Employee employee);

	public List<MockRatings> getMockDetails(String name);

	public Employee getDetails(String name);

	public Employee updateEmployeeDeatils(Employee employee, Integer id);
	
}

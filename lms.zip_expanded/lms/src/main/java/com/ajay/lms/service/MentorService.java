package com.ajay.lms.service;

import java.util.List;

import com.ajay.lms.dto.AddMockDTO;
import com.ajay.lms.dto.DropDownResponse;
import com.ajay.lms.dto.EmployeeStatusDTO;
import com.ajay.lms.pojo.Employee;
import com.ajay.lms.pojo.Mock;
import com.ajay.lms.pojo.MockRatings;

public interface MentorService {
	
	public List<Employee> getAllEmployee(String batchName);

	public List<MockRatings> getEmployeeDetails(String name);

	public Mock createMock(AddMockDTO mock);

	public MockRatings giveMockRatings(MockRatings ratings);

	public List<DropDownResponse> getBatchNameByMentor(String mentorName);

	public List<EmployeeStatusDTO> getstatus(Integer batchId);
	
}

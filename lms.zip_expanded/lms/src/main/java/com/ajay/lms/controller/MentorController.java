package com.ajay.lms.controller;

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

import com.ajay.lms.dto.AddMockDTO;
import com.ajay.lms.dto.DropDownResponse;
import com.ajay.lms.dto.EmployeeStatusDTO;
import com.ajay.lms.dto.ResponseBody;
import com.ajay.lms.pojo.Mock;
import com.ajay.lms.pojo.MockRatings;
import com.ajay.lms.service.MentorService;

import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
@RequestMapping("/api/mentor")
public class MentorController {

	@Autowired
	private MentorService service;

	
	@GetMapping("/batchname/{mentorId}")
	public ResponseEntity<ResponseBody> getBatchName(@PathVariable String mentorId){
		List<DropDownResponse> batchname = service.getBatchNameByMentor(mentorId);
		return new ResponseEntity<>(new ResponseBody(false, "Batch Name of mentor fetched successfully", batchname), HttpStatus.OK);
	}
	
	@GetMapping("/batchdetails/{batchId}")
	public ResponseEntity<ResponseBody> getBatchDetailsOfMentor(@PathVariable Integer batchId){
		List<EmployeeStatusDTO> getstatus = service.getstatus(batchId);
		return new ResponseEntity<>(new ResponseBody(false, "Employee Details of batch fetched successfully", getstatus),HttpStatus.OK);
	}
	
	
	
	@GetMapping("/employeeDetails/{empId}")
	public ResponseEntity<ResponseBody> getDetailsOfEmployee(@PathVariable String empId){
		log.info("employeeeeeeeee" , empId);
		List<MockRatings> details = service.getEmployeeDetails(empId);
		return new ResponseEntity<>(new ResponseBody(false, "Mock Rating of a employee", details),HttpStatus.OK);
		
	}
	
	@PostMapping("/mock")
	public ResponseEntity<ResponseBody> addMock(@RequestBody AddMockDTO mock){
		Mock createMock = service.createMock(mock);
        return	new ResponseEntity<>(new ResponseBody(false, "Mock created", createMock), HttpStatus.OK);
	}

	@PostMapping("/mockRatings")
	public ResponseEntity<ResponseBody> giveMockRatings(@RequestBody MockRatings ratings){
		MockRatings giveMockRatings = service.giveMockRatings(ratings);
		return new ResponseEntity<>(new ResponseBody(false, "Mock Ratings submitted", giveMockRatings),HttpStatus.OK);
	}
}

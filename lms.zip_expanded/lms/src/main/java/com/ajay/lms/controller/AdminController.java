package com.ajay.lms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ajay.lms.dto.AddBatchDTO;
import com.ajay.lms.dto.AddMentorDTO;
import com.ajay.lms.dto.ResponseBody;
import com.ajay.lms.pojo.BatchDetails;
import com.ajay.lms.pojo.Mentor;
import com.ajay.lms.pojo.Technologies;
import com.ajay.lms.service.AdminService;

@RestController
@RequestMapping("/lms/v1/admin/")
@CrossOrigin(origins = "*")
public class AdminController {
	
	@Autowired
	AdminService service;
	
	@PostMapping("/batch")
	public ResponseEntity<ResponseBody> addBatch(@RequestBody AddBatchDTO details) {
		BatchDetails addBatch = service.addBatch(details);
		return new ResponseEntity<>(new ResponseBody(false, "Success", addBatch), HttpStatus.OK);
	}
	
	@PutMapping("/batch/{id}")
	public ResponseEntity<ResponseBody> updateBatch(@RequestBody BatchDetails details,@PathVariable Integer id) {
		return new ResponseEntity<>(new ResponseBody(false, "Success",service.update(details, id)),HttpStatus.OK);
	}
	
	
	@DeleteMapping("/batch/{id}")
	public ResponseEntity<ResponseBody> delete(@PathVariable Integer id) {
		if(id==null) {
			throw new RuntimeException();
		}
		return new ResponseEntity<>(new ResponseBody(false, "Deleted the batch successfully", null),HttpStatus.OK);
	}
	
	@PostMapping("/mentor")
	public ResponseEntity<ResponseBody> addMentor(@RequestBody AddMentorDTO mentorDetails){
		Mentor addMentor = service.addMentor(mentorDetails);
		ResponseBody body = new ResponseBody(false, "Add mentor Successfully", addMentor);
		return new ResponseEntity<ResponseBody>(body, HttpStatus.OK);
	}
	
	@GetMapping("/batch")
	public ResponseEntity<ResponseBody> getAllBatchDetails(){
		List<BatchDetails> allBatchDetails = service.getAllBatchDetails();
		return new ResponseEntity<>(new ResponseBody(false, "All batch details fetched Successfully", allBatchDetails),HttpStatus.OK);
	}
	
	@GetMapping("/mentor")
	public ResponseEntity<ResponseBody> getAllMentorDetails(){
		List<Mentor> allMentorDetails = service.getAllMentorDetails();
		return new ResponseEntity<>(new ResponseBody(false, "All metnor Details fetched Successfully", allMentorDetails),HttpStatus.OK);
	}
	
	@GetMapping("/technologies")
	public ResponseEntity<ResponseBody> getAllTechnologies(){
		List<Technologies> allTechnologies = service.getAllTechnologies();
		return new ResponseEntity<>(new ResponseBody(false, "All technologies fetched Succesfully", allTechnologies), HttpStatus.OK);
	}
	
	
}

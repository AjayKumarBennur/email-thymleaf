package com.ajay.lms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import com.ajay.lms.dto.AddBatchDTO;
import com.ajay.lms.dto.AddMentorDTO;
import com.ajay.lms.pojo.BatchDetails;
import com.ajay.lms.pojo.Mentor;
import com.ajay.lms.pojo.Technologies;
import com.ajay.lms.repo.BatchDetailsRepo;
import com.ajay.lms.repo.MentorRepo;
import com.ajay.lms.repo.TechnologiesRepo;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private BatchDetailsRepo batchRepo;

	@Autowired
	private MentorRepo mentorRepo;

	@Autowired
	private TechnologiesRepo technologiesRepo;

	@Override
	public BatchDetails addBatch(AddBatchDTO details) {
		Mentor mentorDetails = mentorRepo.findByEmpId(details.getMentorId());
		List<Technologies> technologies = technologiesRepo.findAllById(details.getTechId());
		BatchDetails batchDetails = new BatchDetails();
		batchDetails.setBatchName(details.getBatchName());
		batchDetails.setNumber(details.getBatchNumber());
		batchDetails.setStartDate(details.getStartDate());
		batchDetails.setEndDate(details.getEndDate());
		batchDetails.setMentor(mentorDetails);
		batchDetails.setTechnologies(technologies);
		batchDetails.setStatus("Active");
		BatchDetails save = batchRepo.save(batchDetails);
		if (save == null) {
			throw new RuntimeException();
		}
		return save;
	}

	@Override
	public BatchDetails update(BatchDetails details, int id) {
		BatchDetails existing = batchRepo.findById(id).get();
		if (existing == null) {
			throw new RuntimeException();
		}
		existing.setBatchName(details.getBatchName());
		existing.setEndDate(details.getEndDate());
		existing.setMentor(details.getMentor());
		existing.setStatus(details.getStatus());
		existing.setTechnologies(details.getTechnologies());
		return existing;
	}

	@Override
	public void delete(Integer id) {
		batchRepo.deleteById(id);
	}

	@Override
	public Mentor addMentor(AddMentorDTO mentordetails) {
		Mentor findByEmpId = mentorRepo.findByEmpId(mentordetails.getEmpId());
		if (findByEmpId == null) {
			Mentor mentor = new Mentor();
			mentor.setEmpId(mentordetails.getEmpId());
			mentor.setEmail(mentordetails.getEmailId());
			mentor.setMentorName(mentordetails.getName());
			List<Technologies> byTechIn = technologiesRepo.findByTechIn(mentordetails.getTechId());
			mentor.setTechnologies(byTechIn);
			return mentor;
		} else {
			findByEmpId.setEmpId(mentordetails.getEmpId());
			findByEmpId.setEmail(mentordetails.getEmailId());
			findByEmpId.setMentorName(mentordetails.getName());
			List<Technologies> byTechIn = technologiesRepo.findByTechIn(mentordetails.getTechId());
			findByEmpId.setTechnologies(byTechIn);
			return findByEmpId;
		}
	}

	@Override
	public List<BatchDetails> getAllBatchDetails() {
		List<BatchDetails> batchDetails = batchRepo.findAll();
		if (batchDetails == null) {
			throw new RuntimeException();
		}
		return batchDetails;
	}

	@Override
	public List<Mentor> getAllMentorDetails() {
		List<Mentor> mentorDetails = mentorRepo.findAll();
		if (mentorDetails == null) {
			throw new RuntimeException();
		}
		return mentorDetails;
	}

	@Override
	public List<Technologies> getAllTechnologies() {
		List<Technologies> technologies = technologiesRepo.findAll();
		if (technologies == null) {
			throw new RuntimeException();
		}
		return technologies;
	}

}

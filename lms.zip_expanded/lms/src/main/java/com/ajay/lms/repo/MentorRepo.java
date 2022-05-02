package com.ajay.lms.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ajay.lms.pojo.Mentor;

public interface MentorRepo extends JpaRepository<Mentor, Integer>{
	public Mentor findByEmpId(String empId);
	public List<Mentor> findByEmpIdIn(List<String> id);
}

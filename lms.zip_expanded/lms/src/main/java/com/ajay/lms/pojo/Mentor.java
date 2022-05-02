package com.ajay.lms.pojo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
public class Mentor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String mentorName;
	private String empId;
	private String email;
	@ManyToMany
	private List<Technologies> technologies;
	@OneToMany(mappedBy = "mentor")
	private List<BatchDetails> batchDetails;
}

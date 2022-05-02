package com.ajay.lms.pojo;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
@Entity
@Table(name = "employee_primary_info")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(unique = true)
	private String empId;
	private String empName;
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate doj;
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dob;
	private String email;
	private String bloodGroup;
	private String designation;
	private String gender;
	private String nationality;
	private String status;
	
	
	@OneToOne(cascade = CascadeType.ALL)
	private SecondaryInfo info;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<EducationDetails> details;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Address> address;
	
	@OneToOne(cascade = CascadeType.ALL)
	private BankDetails bankDetails;
	
	@ManyToMany(cascade = CascadeType.ALL)
	private List<Technologies> tech;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Experience> exp;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Contact> contact;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "employee")
	private List<MockRatings> ratings;
	
}

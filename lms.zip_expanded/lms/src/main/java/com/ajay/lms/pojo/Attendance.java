package com.ajay.lms.pojo;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
public class Attendance {
	private int id;
	private LocalDate date;
	private boolean morning;
	private boolean afternoon;
	private String leaveReason;
}

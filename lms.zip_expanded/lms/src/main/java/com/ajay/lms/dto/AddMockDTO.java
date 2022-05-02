package com.ajay.lms.dto;

import java.time.LocalDateTime;
import java.util.List;

import lombok.Data;

@Data
public class AddMockDTO {
	
	private int mockNo;
	private int techId;
	private List<String> mentorId;
	private LocalDateTime dateTime;
	
}

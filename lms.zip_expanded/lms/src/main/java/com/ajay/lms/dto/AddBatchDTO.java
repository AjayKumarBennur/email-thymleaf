package com.ajay.lms.dto;

import java.time.LocalDate;
import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class AddBatchDTO {
	@NotNull
	@NotEmpty
	private int batchNumber;
	@NotNull
	@NotEmpty
	private String batchName;
	@NotNull
	@NotEmpty
	private String mentorId;
	@NotNull
	private List<Integer> techId;
	@JsonFormat(pattern = "yyyy/MM/dd")
	private LocalDate startDate;
	@JsonFormat(pattern = "yyyy/MM/dd")
	private LocalDate endDate;
}

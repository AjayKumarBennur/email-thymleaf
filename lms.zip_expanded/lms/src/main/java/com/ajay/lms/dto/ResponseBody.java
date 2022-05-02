package com.ajay.lms.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResponseBody {
	
	private boolean error;
	private String msg;
	private Object data;
	
}

package com.openeye.employee.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ResponseMessage implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4941831466356188873L;
	private String messsage;
	private String error;
	private LocalDateTime timestamp;
}

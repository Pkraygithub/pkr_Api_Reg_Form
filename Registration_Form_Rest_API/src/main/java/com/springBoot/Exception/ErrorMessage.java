package com.springBoot.Exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorMessage {
	
	private String Message;
	private String dateTime;
	private String module;

}

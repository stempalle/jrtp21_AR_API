package com.sharathit.binding;

import java.time.LocalDate;

import lombok.Data;

@Data
public class CitizenApp {

	private String fullName;
	private Long mobNo;
	private LocalDate dob;
	private String emailId;
	private String gender;
	private Long SSN;

}

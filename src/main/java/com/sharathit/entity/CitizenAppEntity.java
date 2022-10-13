package com.sharathit.entity;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Entity
@Table(name = "CITIZEN_APPS")
@Data
public class CitizenAppEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer appId;
	private String fullName;
	private Long mobNo;
	private Date dob;
	private String emailId;
	private String gender;
	private Long SSN;
	private String state;

	@CreationTimestamp
	private LocalDate createdDate;

	@UpdateTimestamp
	private LocalDate updatedDate;
	
	private String createdBy;
	private String updatedBy;

}

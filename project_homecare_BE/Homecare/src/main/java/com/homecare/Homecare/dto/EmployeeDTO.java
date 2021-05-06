package com.homecare.Homecare.dto;

import java.util.Date;

import javax.validation.constraints.Email;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDTO {
	private String id ;
	private String fullName ;
	private String phone ;
	private double salary;
	private String indentity;
	private String email ;
	private String address ;
	private String province ;
	private String department ;
	private Date birthday;
	private Date daytowork;
	private String gender ;
	private String image ;
}

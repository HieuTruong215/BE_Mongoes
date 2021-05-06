package com.homecare.Homecare.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BookingDTO {
	private String id ;
	private String address ;
	private String brand ;
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date date ;
	private String description ;
	private String district ;
	private String email ;
	private String fullname ;
	private String phone ;
	private String product ;
	private String province ;
	private String service ;
	private String status ;
	private String rate ;
}

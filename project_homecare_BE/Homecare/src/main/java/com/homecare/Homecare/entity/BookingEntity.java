package com.homecare.Homecare.entity;

import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "booking")
public class BookingEntity {
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

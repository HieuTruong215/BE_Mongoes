package com.homecare.Homecare.convert;

import org.springframework.stereotype.Component;

import com.homecare.Homecare.dto.BookingDTO;
import com.homecare.Homecare.entity.BookingEntity;

@Component
public class BookingConvert {
	public BookingEntity dtoToEntity(BookingDTO bookingDTO) {
		BookingEntity bookingEntity = new BookingEntity() ;
		bookingEntity.setAddress(bookingDTO.getAddress());
		bookingEntity.setBrand(bookingDTO.getBrand());
		bookingEntity.setDate(bookingDTO.getDate());
		bookingEntity.setDescription(bookingDTO.getDescription());
		bookingEntity.setDistrict(bookingDTO.getDistrict());
		bookingEntity.setEmail(bookingDTO.getEmail());
		bookingEntity.setFullname(bookingDTO.getFullname());
		bookingEntity.setPhone(bookingDTO.getPhone());
		bookingEntity.setProduct(bookingDTO.getProduct());
		bookingEntity.setProvince(bookingDTO.getProvince());
		bookingEntity.setService(bookingDTO.getService());
		bookingEntity.setStatus(bookingDTO.getStatus());
		bookingEntity.setRate(bookingDTO.getRate());
		return bookingEntity ;
	}
	public BookingDTO entityToDTO(BookingEntity bookingEntity) {
		BookingDTO bookingDTO = new BookingDTO() ;
		bookingDTO.setAddress(bookingEntity.getAddress());
		bookingDTO.setBrand(bookingEntity.getBrand());
		bookingDTO.setDate(bookingEntity.getDate());
		bookingDTO.setDescription(bookingEntity.getDescription());
		bookingDTO.setDistrict(bookingEntity.getDistrict());
		bookingDTO.setEmail(bookingEntity.getEmail());
		bookingDTO.setFullname(bookingEntity.getFullname());
		bookingDTO.setPhone(bookingEntity.getPhone());
		bookingDTO.setProduct(bookingEntity.getProduct());
		bookingDTO.setProvince(bookingEntity.getProvince());
		bookingDTO.setService(bookingEntity.getService());
		bookingDTO.setStatus(bookingEntity.getStatus());
		bookingDTO.setRate(bookingEntity.getRate());
		return bookingDTO ;
	}
}

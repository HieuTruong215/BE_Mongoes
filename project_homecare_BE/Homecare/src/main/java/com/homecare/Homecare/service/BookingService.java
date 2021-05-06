package com.homecare.Homecare.service;

import java.awt.color.ICC_ColorSpace;
import java.util.List;
import java.util.Optional;
import java.util.Properties;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.homecare.Homecare.convert.BookingConvert;
import com.homecare.Homecare.dto.BookingDTO;
import com.homecare.Homecare.entity.BookingEntity;
import com.homecare.Homecare.entity.EmployeeEntity;
import com.homecare.Homecare.exception.BadRequestException;
import com.homecare.Homecare.exception.NotFoundException;
import com.homecare.Homecare.reponse.success.SuccessResponse;
import com.homecare.Homecare.repository.BookingRepository;

@Service
public class BookingService {
	@Autowired
	private BookingRepository bookingRepository;
	@Autowired
	private BookingConvert bookingConvert;
	private JavaMailSender javaMailSender;
	@Autowired
	public BookingService(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}
	@Transactional
	public SuccessResponse edit(BookingDTO bookingDTO) {
		if (this.findById(bookingDTO.getId()) == null)
			throw new NotFoundException("");
		{
			Optional<BookingEntity> optionalBookingEntity = bookingRepository.findById(bookingDTO.getId());
			BookingEntity bookingEntity = optionalBookingEntity.orElseThrow(() -> new BadRequestException("ID not correct"));
			bookingEntity.setAddress(bookingDTO.getAddress());
			bookingEntity.setBrand(bookingDTO.getBrand());
			bookingEntity.setDate(bookingDTO.getDate());
			bookingEntity.setDescription(bookingDTO.getDescription());
			bookingEntity.setDistrict(bookingDTO.getDistrict());
			bookingEntity.setEmail(bookingDTO.getEmail());
			bookingEntity.setFullname(bookingDTO.getFullname());
			bookingEntity.setId(bookingDTO.getId());
			bookingEntity.setPhone(bookingDTO.getPhone());
			bookingEntity.setProduct(bookingDTO.getProduct());
			bookingEntity.setProvince(bookingDTO.getProvince());
			bookingEntity.setService(bookingDTO.getService());
			bookingEntity.setStatus(bookingDTO.getStatus());
			bookingConvert.entityToDTO(bookingRepository.save(bookingEntity));
		}
		return new SuccessResponse();
	} 
	
	@Transactional
	public SuccessResponse save(BookingDTO bookingDTO) {
		BookingEntity bookingEntity = new BookingEntity();
			
			UUID id = UUID.randomUUID();
			bookingDTO.setId(id.toString());	
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
			bookingEntity.setStatus("Chưa xử lý");
			bookingEntity.setRate(bookingDTO.getRate());
			SimpleMailMessage mail = new SimpleMailMessage();
			mail.setTo(bookingDTO.getEmail());
			mail.setSubject("Đặt lịch thành công tại HOMECARE !");
			mail.setText("Bạn đã đặt lịch sửa chữa thiết bị tại Homecare vào " + bookingDTO.getDate() + " ! Vui lòng giữ thiết bị để"
					+ " nhân viên sửa chữa có thể liên hệ ");
			javaMailSender.send(mail);
			bookingRepository.save(bookingEntity);
			SuccessResponse successResponse = new SuccessResponse();
			successResponse.setCode(201);
			return successResponse ;
		
	}
	@Transactional
	 public SuccessResponse delete(String bookingId) {
	        Optional<BookingEntity> bookingEntityOptional = this.bookingRepository.findById(bookingId);
	        if (!bookingEntityOptional.isPresent()) {
	            throw new NotFoundException("Booking");
	        }

	        this.bookingRepository.deleteById(bookingId);

	        return new SuccessResponse();
	    }
	
	public SuccessResponse findById(String idBooking) {
		Optional<BookingEntity> optionalBooking = bookingRepository.findById(idBooking);
		
		if (optionalBooking.isPresent()) {
			return new SuccessResponse(this.bookingConvert.entityToDTO(optionalBooking.get()));
		}
		return new SuccessResponse();
	}

	public SuccessResponse findAllBooking() {
		SuccessResponse successResponse = new SuccessResponse();
		successResponse.setData(bookingRepository.findAll());
		return successResponse;
	}
	public SuccessResponse addRate(BookingDTO bookingDTO) {
		if (this.findById(bookingDTO.getId()) == null)
			throw new NotFoundException("");
		{
			Optional<BookingEntity> optionalBookingEntity = bookingRepository.findById(bookingDTO.getId());
			BookingEntity bookingEntity = optionalBookingEntity.orElseThrow(() -> new BadRequestException("ID not correct"));
			bookingEntity.setRate(bookingDTO.getRate());
			bookingConvert.entityToDTO(bookingRepository.save(bookingEntity));
		}
		return new SuccessResponse();
	}
	public List<BookingEntity> getAllByEmail(String email) {
		return bookingRepository.findAllByEmail(email);  
	}
}


package com.homecare.Homecare.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.homecare.Homecare.dto.BookingDTO;
import com.homecare.Homecare.dto.BrandDTO;
import com.homecare.Homecare.dto.ComboDTO;
import com.homecare.Homecare.entity.BookingEntity;
import com.homecare.Homecare.reponse.success.SuccessResponse;
import com.homecare.Homecare.service.BookingService;
import com.homecare.Homecare.service.MailService;

@RestController
@RequestMapping("api/v1")
public class BookingController {
@Autowired
private BookingService bookingService ;

@Autowired
private MailService notificationService;

@PutMapping("/{id}/edit/booking")
public SuccessResponse<BookingDTO> editStatus(@RequestBody BookingDTO bookingDTO) {
    return this.bookingService.edit(bookingDTO);
} 

@GetMapping("/booking")
public SuccessResponse<BookingDTO> findAll(){
	return bookingService.findAllBooking();
}
@GetMapping("/booking/{id}")
public SuccessResponse<BookingDTO> findById(@PathVariable String id){
	return bookingService.findById(id) ;
}
@DeleteMapping("/booking/{idBooking}")
@ResponseBody
public SuccessResponse deleteBooking(@PathVariable("idBooking") String idEmployee) {
    return this.bookingService.delete(idEmployee);
}
@PostMapping("/add/booking")
public SuccessResponse addBooking(@RequestBody BookingDTO bookingDTO) {
	notificationService.sendEmail(bookingDTO.getEmail()) ;
	return this.bookingService.save(bookingDTO) ;
}
@GetMapping("booking/email")
public List<BookingEntity> getAllByEmail(@RequestParam("email") String email){
	return bookingService.getAllByEmail(email) ;
}
@PutMapping("booking/{id}")
public SuccessResponse edit(@RequestBody BookingDTO bookingDTO) {
    return this.bookingService.addRate(bookingDTO);
}
}

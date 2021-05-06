package com.homecare.Homecare.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.homecare.Homecare.dto.BookingDTO;
import com.homecare.Homecare.service.MailService;




@RestController
public class SendController {

	@Autowired
	private MailService notificationService;


	private BookingDTO bookingDTO;
	@PostMapping("/send/booking")
	public String send() {
		try {
			notificationService.sendEmail(bookingDTO.getEmail());
		} catch (MailException mailException) {
			System.out.println(mailException);
		}
		return "Congratulations! Your mail has been send to the user.";
	}
}

package com.shashikant.project.uber.uberApp;

import com.shashikant.project.uber.uberApp.services.EmailSenderService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UberApplicationTests {

	@Autowired
	private EmailSenderService emailSenderService;


	@Test
	void contextLoads() {
		emailSenderService.sendEmail("rogac11380@skrank.com",
				"First mail",
				"Happy to send my first email ");
	}

	@Test
	void sendEmailMultiple(){

		String[] toEmail = {"rogac11380@skrank.com", "shashikantyadav0@gmail.com", "rachnayadav8131@gmail.com"};

		emailSenderService.sendEmailMultiple(toEmail,
				"First mail",
				"Happy to send my first email ");
	}

}

package com.backend.fullstack;

import com.backend.fullstack.service.impl.EmailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class FullstackApplication {
	/*
	@Autowired
	private EmailSenderService senderService;*/

	public static void main(String[] args) {
		SpringApplication.run(FullstackApplication.class, args);

	}
	/*
	@EventListener(ApplicationReadyEvent.class)
	public void sendMail(){
		senderService.sendEmail("sai.charan73@yahoo.com","This is subject","This is Body of email");

	}
*/
}

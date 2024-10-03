package com.shashikant.project.uber.uberApp.services;

import org.springframework.stereotype.Service;


public interface EmailSenderService {

     void sendEmail(String toEmail, String subject, String body);
     void sendEmailMultiple(String[] toEmail, String subject, String body);

}

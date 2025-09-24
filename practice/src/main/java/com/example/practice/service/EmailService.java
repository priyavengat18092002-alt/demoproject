package com.example.practice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendEmail(String to, String subject, String body) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("bahij71294@cnguopin.com");
        message.setTo("priyavengat18092002@gmail.com");
        message.setSubject(subject);
        message.setText(body);

        mailSender.send(message);
    }
}

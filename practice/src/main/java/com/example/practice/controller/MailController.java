package com.example.practice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.practice.service.EmailService;

import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/email")
@RequiredArgsConstructor
public class MailController {

    private final EmailService emailService;

    @GetMapping("/send-test")
    public String sendTestEmail() throws MessagingException {
        emailService.sendTemplateEmail(
            "priyavengat18092002@gmail.com",
            "Regarding Onboarding",
            "Priya",
            "25/09/2025"
        );
        return "Email sent successfully!";
    }
}

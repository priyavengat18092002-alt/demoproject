package com.example.practice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.practice.service.EmailService;

@RestController
@RequestMapping("/email")
public class MailController {

    private final EmailService emailService;

    public MailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @GetMapping("/send-test")
    public String sendTestEmail() {
        emailService.sendEmail(
            "priyavengat18092002@gmail.com",
            "Regarding Onboarding",
            "Congratulations! , This message is from  Hemas Enterprises regarding your onboarding."
        );
        return "Email sent successfully!";
    }
}

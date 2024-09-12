package com.aleksandr.blogca2023.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendCommentNotification(String comment, String recipientEmail) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("your-email@example.com");
        message.setTo("mynotprimaryemail@gmail.com");
        message.setSubject("New Comment Received");
        message.setText(comment);
        mailSender.send(message);
    }
}

package com.aleksandr.blogca2023.controller;

import com.aleksandr.blogca2023.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comments")
public class CommentController {

    @Autowired
    private EmailService emailService;

    @PostMapping("/add")
    public String addComment(@RequestParam String comment, @RequestParam String email) {
        emailService.sendCommentNotification(comment, "recipient@example.com");
        return "Comment submitted and email sent!";
    }
}
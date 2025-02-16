package com.example.demo.controllers;

import com.example.demo.entities.EmailModel;
import com.example.demo.services.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/email")
@CrossOrigin(origins = "http://localhost:3000")
public class EmailController {

    @Autowired
    private EmailService emailService;

    @PostMapping("/sendemail")
    public ResponseEntity<String> sendEmail(
            @RequestParam("recipient") String recipient,
            @RequestParam("subject") String subject,
            @RequestParam("message") String message,
            @RequestParam(value = "file", required = false) MultipartFile file) {
        try {
            EmailModel emailModel = new EmailModel();
            emailModel.setToMail(recipient);
            emailModel.setEmailSubject(subject);
            emailModel.setEmailBody(message);

            emailService.sendEmailWithAttachment(emailModel, file);
            return new ResponseEntity<>("Email sent successfully", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to send email: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
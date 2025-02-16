package com.example.demo.services;

import com.example.demo.entities.EmailModel;
import org.springframework.web.multipart.MultipartFile;

public interface IEmailService {
    void sendEmailWithAttachment(EmailModel emailModel, MultipartFile file);
}
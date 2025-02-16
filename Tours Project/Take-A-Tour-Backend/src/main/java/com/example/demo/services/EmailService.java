
package com.example.demo.services;

import com.example.demo.entities.EmailModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
public class EmailService implements IEmailService {

    @Autowired
    private JavaMailSender mailSender;

    @Override
    public void sendEmailWithAttachment(EmailModel emailModel, MultipartFile file) {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        try {
            MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, true);
            messageHelper.setTo(emailModel.getToMail());
            messageHelper.setSubject(emailModel.getEmailSubject());
            messageHelper.setText(emailModel.getEmailBody());

            if (file != null && !file.isEmpty()) {
                String fileName = file.getOriginalFilename();
                messageHelper.addAttachment(fileName, file);
            }

            mailSender.send(mimeMessage);
        } catch (MessagingException e) {
            throw new RuntimeException("Failed to send email: " + e.getMessage(), e);
        }
    }
}
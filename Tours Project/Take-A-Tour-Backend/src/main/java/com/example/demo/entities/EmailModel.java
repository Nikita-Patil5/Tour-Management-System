package com.example.demo.entities;

public class EmailModel {
    private String toMail;
    private String ccEmail;
    private String emailSubject;
    private String emailBody;
    private String emailAttachment;

    // Getters and Setters
    public String getToMail() {
        return toMail;
    }

    public void setToMail(String toMail) {
        this.toMail = toMail;
    }

    public String getCcEmail() {
        return ccEmail;
    }

    public void setCcEmail(String ccEmail) {
        this.ccEmail = ccEmail;
    }

    public String getEmailSubject() {
        return emailSubject;
    }

    public void setEmailSubject(String emailSubject) {
        this.emailSubject = emailSubject;
    }

    public String getEmailBody() {
        return emailBody;
    }

    public void setEmailBody(String emailBody) {
        this.emailBody = emailBody;
    }

    public String getEmailAttachment() {
        return emailAttachment;
    }

    public void setEmailAttachment(String emailAttachment) {
        this.emailAttachment = emailAttachment;
    }
}
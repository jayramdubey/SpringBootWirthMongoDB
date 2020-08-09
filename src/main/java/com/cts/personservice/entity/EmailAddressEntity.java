package com.cts.personservice.entity;

public class EmailAddressEntity {

    private String emailId;
    private String email;
    private EmailTypeEntity emailType;

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public EmailTypeEntity getEmailType() {
        return emailType;
    }

    public void setEmailType(EmailTypeEntity emailType) {
        this.emailType = emailType;
    }
}

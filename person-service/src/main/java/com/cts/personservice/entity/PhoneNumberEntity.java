package com.cts.personservice.entity;

public class PhoneNumberEntity {

    private String phoneId;
    private String phoneNumber;
    private PhoneTypeEntity phoneType;

    public String getPhoneId() {
        return phoneId;
    }

    public void setPhoneId(String phoneId) {
        this.phoneId = phoneId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public PhoneTypeEntity getPhoneType() {
        return phoneType;
    }

    public void setPhoneType(PhoneTypeEntity phoneType) {
        this.phoneType = phoneType;
    }
}

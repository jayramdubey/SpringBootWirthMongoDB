package com.cts.personservice.model;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;

public class Person {

    private String personId;
    @Valid
    private Name name;
    private LocalDate dob;
    private List<EmailAddress> emails;
    private List<PhoneNumber> phones;
    private List<Address> address;
    private Boolean verified;

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public List<EmailAddress> getEmails() {
        return emails;
    }

    public void setEmails(List<EmailAddress> emails) {
        this.emails = emails;
    }

    public List<PhoneNumber> getPhones() {
        return phones;
    }

    public void setPhones(List<PhoneNumber> phones) {
        this.phones = phones;
    }

    public List<Address> getAddress() {
        return address;
    }

    public void setAddress(List<Address> address) {
        this.address = address;
    }

    public Boolean getVerified() {
        return verified;
    }

    public void setVerified(Boolean verified) {
        this.verified = verified;
    }
}

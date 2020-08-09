package com.cts.personservice.entity;

import com.cts.personservice.model.Address;
import com.cts.personservice.model.EmailAddress;
import com.cts.personservice.model.PhoneNumber;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static com.cts.personservice.constant.Constants.Collections.PERSON_COLLECTION;

@Document(collection = PERSON_COLLECTION)
public class PersonEntity {

    @Id
    private String personId;
    private NameEntity nameEntity;
    private LocalDate dob;
    private List<EmailAddressEntity> emails;
    private List<PhoneNumberEntity> phones;
    private List<AddressEntity> address;
    private boolean verified;
    @Version
    private Long version;
    private LocalDateTime createdDate;
    private LocalDateTime lastModifiedDate;


    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public NameEntity getNameEntity() {
        return nameEntity;
    }

    public void setNameEntity(NameEntity nameEntity) {
        this.nameEntity = nameEntity;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public List<EmailAddressEntity> getEmails() {
        return emails;
    }

    public void setEmails(List<EmailAddressEntity> emails) {
        this.emails = emails;
    }

    public List<PhoneNumberEntity> getPhones() {
        return phones;
    }

    public void setPhones(List<PhoneNumberEntity> phones) {
        this.phones = phones;
    }

    public List<AddressEntity> getAddress() {
        return address;
    }

    public void setAddress(List<AddressEntity> address) {
        this.address = address;
    }

    public boolean isVerified() {
        return verified;
    }

    public void setVerified(boolean verified) {
        this.verified = verified;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public LocalDateTime getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(LocalDateTime lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }
}

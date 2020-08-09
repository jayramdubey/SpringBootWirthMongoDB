package com.cts.personservice.service.converter;


import com.cts.personservice.entity.*;
import com.cts.personservice.model.*;
import com.cts.personservice.util.EnumConvertUtils;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static org.apache.commons.lang3.BooleanUtils.toBoolean;
import static org.springframework.util.CollectionUtils.isEmpty;

@Component
public class PersonConverter {

    // Person
    public List<Person> personsEntityToModel(List<PersonEntity> personEntities) {
        List<Person> persons = Collections.emptyList();
        if (!isEmpty(personEntities)) {
            persons = personEntities.stream()
                    .filter(Objects::nonNull)
                    .map(this::personEntityToModel)
                    .collect(Collectors.toList());
        }
        return persons;
    }

    public PersonEntity personModelToEntity(Person person) {
        PersonEntity personEntity = new PersonEntity();
        personEntity.setNameEntity(nameModelToEntity(person.getName()));
        personEntity.setPersonId(person.getPersonId());
        personEntity.setVerified(toBoolean(person.getVerified()));
        personEntity.setEmails(emailModelToEntity(person.getEmails()));
        personEntity.setPhones(phonesModelToEntity(person.getPhones()));
        return personEntity;
    }

    public Person personEntityToModel(PersonEntity personEntity) {
        Person person = new Person();
        person.setName(nameEntityToModel(personEntity));
        person.setPersonId(personEntity.getPersonId());
        person.setEmails(emailsEntityToModel(personEntity.getEmails()));
        person.setPhones(phonesEntityToModel(personEntity.getPhones()));
        return person;
    }

    // Name
    public NameEntity nameModelToEntity(Name name) {
        NameEntity nameEntity = new NameEntity();
        nameEntity.setFirstName(name.getFirstName());
        nameEntity.setLastName(name.getLastName());
        nameEntity.setMiddleName(name.getMiddleName());
        nameEntity.setPrefix(name.getPrefix());
        nameEntity.setSuffix(name.getSuffix());
        return nameEntity;
    }

    public Name nameEntityToModel(PersonEntity personEntity) {
        Name name = new Name();
        name.setFirstName(personEntity.getNameEntity().getFirstName());
        name.setLastName(personEntity.getNameEntity().getLastName());
        name.setMiddleName(personEntity.getNameEntity().getMiddleName());
        name.setPrefix(personEntity.getNameEntity().getPrefix());
        name.setSuffix(personEntity.getNameEntity().getSuffix());
        return name;
    }

    // Phone
    public List<PhoneNumberEntity> phonesModelToEntity(List<PhoneNumber> phones) {
        List<PhoneNumberEntity> phoneEntities = Collections.emptyList();
        if (!isEmpty(phones)) {
            phoneEntities = phones.stream()
                    .map(this::phoneModelToEntity)
                    .collect(Collectors.toList());
        }
        return phoneEntities;
    }

    public List<PhoneNumber> phonesEntityToModel(List<PhoneNumberEntity> phoneEntities) {
        List<PhoneNumber> phones = Collections.emptyList();
        if (!isEmpty(phoneEntities)) {
            phones = phoneEntities.stream()
                    .map(this::phoneEntityToModel)
                    .collect(Collectors.toList());
        }
        return phones;
    }

    public PhoneNumberEntity phoneModelToEntity(PhoneNumber phoneNumber) {
        PhoneNumberEntity phoneNumberEntity = new PhoneNumberEntity();
        phoneNumberEntity.setPhoneId(phoneNumber.getPhoneId());
        phoneNumberEntity.setPhoneNumber(phoneNumber.getPhoneNumber());
        phoneNumberEntity.setPhoneType(EnumConvertUtils.convertEnum(PhoneTypeEntity.class, phoneNumber.getPhoneType()));
        return phoneNumberEntity;
    }

    public PhoneNumber phoneEntityToModel(PhoneNumberEntity phoneNumberEntity) {
        PhoneNumber phoneNumber = new PhoneNumber();
        phoneNumber.setPhoneId(phoneNumberEntity.getPhoneId());
        phoneNumber.setPhoneNumber(phoneNumberEntity.getPhoneNumber());
        phoneNumber.setPhoneType(EnumConvertUtils.convertEnum(PhoneType.class, phoneNumberEntity.getPhoneType()));
        return phoneNumber;
    }

    // Email
    public List<EmailAddressEntity> emailModelToEntity(List<EmailAddress> emails) {
        List<EmailAddressEntity> emailEntities = Collections.emptyList();
        if (!isEmpty(emails)) {
            emailEntities = emails.stream()
                    .map(this::emailModelToEntity)
                    .collect(Collectors.toList());
        }
        return emailEntities;
    }

    public List<EmailAddress> emailsEntityToModel(List<EmailAddressEntity> emailEntities) {
        List<EmailAddress> emails = Collections.emptyList();
        if (!isEmpty(emailEntities)) {
            emails = emailEntities.stream()
                    .map(this::emailEntityToModel)
                    .collect(Collectors.toList());
        }
        return emails;
    }

    public EmailAddressEntity emailModelToEntity(EmailAddress emailAddress) {
        EmailAddressEntity emailAddressEntity = new EmailAddressEntity();
        emailAddressEntity.setEmail(emailAddress.getEmail());
        emailAddressEntity.setEmailId(emailAddress.getEmailId());
        emailAddressEntity.setEmailType(EnumConvertUtils.convertEnum(EmailTypeEntity.class, emailAddress.getEmailType()));
        return emailAddressEntity;
    }

    public EmailAddress emailEntityToModel(EmailAddressEntity emailAddressEntity) {
        EmailAddress emailAddress = new EmailAddress();
        emailAddress.setEmail(emailAddressEntity.getEmail());
        emailAddress.setEmailId(emailAddressEntity.getEmailId());
        emailAddress.setEmailType(EnumConvertUtils.convertEnum(EmailType.class, emailAddressEntity.getEmailType()));
        return emailAddress;
    }

    //Address
    public List<AddressEntity> addressModelToEntity(List<Address> addresses) {
        List<AddressEntity> addressEntities = Collections.emptyList();
        if (!isEmpty(addresses)) {
            addressEntities = addresses.stream()
                    .map(this::addressModelToEntity)
                    .collect(Collectors.toList());
        }
        return addressEntities;
    }

    public List<Address> addressEntityToModel(List<AddressEntity> addressEntities) {
        List<Address> address = Collections.emptyList();
        if (!isEmpty(addressEntities)) {
            address = addressEntities.stream()
                    .map(this::addressEntityToModel)
                    .collect(Collectors.toList());
        }
        return address;
    }

    public AddressEntity addressModelToEntity(Address address) {
        AddressEntity addressEntity = new AddressEntity();
        addressEntity.setAddressId(address.getAddressId());
        addressEntity.setAddressLines(address.getAddressLines());
        addressEntity.setCity(address.getCity());
        addressEntity.setDistrict(address.getDistrict());
        addressEntity.setPinCode(address.getPinCode());
        addressEntity.setState(address.getState());
        //addressEntity.setAddressType(address.getAddressType().);
        return addressEntity;
    }

    public Address addressEntityToModel(AddressEntity addressEntity) {
        Address address = new Address();
        address.setAddressId(addressEntity.getAddressId());
        address.setAddressLines(addressEntity.getAddressLines());
        address.setCity(addressEntity.getCity());
        address.setDistrict(addressEntity.getDistrict());
        address.setState(addressEntity.getState());
        address.setPinCode(addressEntity.getPinCode());
        //address.setAddressType();

        return address;
    }

    // Person Search
    public PersonSearchEntity personSearchModelToEntity(PersonSearch personSearch) {
        PersonSearchEntity personSearchEntity = new PersonSearchEntity();
        personSearchEntity.setFirstName(personSearch.getFirstName());
        personSearchEntity.setLastName(personSearch.getLastName());
        personSearchEntity.setMiddleName(personSearch.getMiddleName());
        personSearchEntity.setEmail(personSearch.getEmail());
        personSearchEntity.setPhoneNumber(personSearch.getPhoneNumber());
        personSearchEntity.setPinCode(personSearch.getPinCode());
        personSearchEntity.setCity(personSearch.getCity());
        personSearchEntity.setAddressLines(personSearch.getAddressLines());
        personSearchEntity.setState(personSearch.getState());
        return personSearchEntity;
    }


}

package com.cts.personservice.config;

import com.cts.personservice.entity.PersonEntity;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

import static com.cts.personservice.util.GenerateIdUtils.getUUID;
import static java.util.Objects.isNull;
import static org.apache.commons.lang3.StringUtils.isEmpty;

@Component
public class PersonMongoListener extends AbstractMongoEventListener<PersonEntity> {

    @Override
    public void onBeforeConvert(BeforeConvertEvent<PersonEntity> event) {
        if (isNull(event.getSource().getPersonId())) {
            event.getSource().setPersonId(getUUID());
        }
        if (isNull(event.getSource().getCreatedDate())) {
            event.getSource().setCreatedDate(LocalDateTime.now());
        }
        if (isNull(event.getSource().getLastModifiedDate())) {
            event.getSource().setLastModifiedDate(LocalDateTime.now());
        }
        if (!isNull(event.getSource().getAddress())) {
            generateAddressIds(event);
        }
        if (!isNull(event.getSource().getEmails())) {
            generateEmailIds(event);
        }
        if (!isNull(event.getSource().getPhones())) {
            generatePhoneIds(event);
        }
        super.onBeforeConvert(event);
    }

    private void generateAddressIds(BeforeConvertEvent<PersonEntity> event) {
        event.getSource().getAddress()
                .forEach(addressEntity -> {
                    if (isEmpty(addressEntity.getAddressId())) {
                        addressEntity.setAddressId(getUUID());
                    }
                });
    }

    private void generateEmailIds(BeforeConvertEvent<PersonEntity> event) {
        event.getSource().getEmails()
                .forEach(emailEntity -> {
                    if (isEmpty(emailEntity.getEmailId())) {
                        emailEntity.setEmailId(getUUID());
                    }
                });
    }

    private void generatePhoneIds(BeforeConvertEvent<PersonEntity> event) {
        event.getSource().getPhones()
                .forEach(phoneEntity -> {
                    if (isEmpty(phoneEntity.getPhoneId())) {
                        phoneEntity.setPhoneId(getUUID());
                    }
                });
    }

}

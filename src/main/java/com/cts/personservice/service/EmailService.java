package com.cts.personservice.service;


import com.cts.personservice.constant.Constants;
import com.cts.personservice.entity.EmailAddressEntity;
import com.cts.personservice.entity.PersonEntity;
import com.cts.personservice.entity.PersonSearchEntity;
import com.cts.personservice.exception.RecordNotFoundException;
import com.cts.personservice.model.*;
import com.cts.personservice.repository.PersonRepository;
import com.cts.personservice.service.converter.PersonConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static com.cts.personservice.util.EncodingUtils.decodeVersion;
import static com.cts.personservice.util.EncodingUtils.encodeVersion;

@Service
public class EmailService {

    private static final Logger LOG = LoggerFactory.getLogger(EmailService.class);

    private final PersonConverter personConverter;
    private final PersonRepository personRepository;

    public EmailService(PersonConverter personConverter, PersonRepository personRepository) {
        this.personConverter = personConverter;
        this.personRepository = personRepository;
    }

    public String createEmail(String personId, List<EmailAddress> emailAddress) {
        LOG.info("Creating email");
        Optional<PersonEntity> personEntity = personRepository.findById(personId);
        personEntity.orElseThrow(() -> new RecordNotFoundException("Person not found with personId=" + personId));
        List<EmailAddressEntity> emailAddressEntity = personConverter.emailModelToEntity(emailAddress);
        personEntity.get().getEmails().addAll(emailAddressEntity);
        personRepository.save(personEntity.get());

        return encodeVersion(personEntity.get().getVersion());
    }

    //Delete emailId
    public void deleteEmail(String personId, String emailId) {
        LOG.info("Deleting Email with personId={}"+ emailId);
        Optional<PersonEntity> personEntity = personRepository.findById(personId);
        personEntity.orElseThrow(() -> new RecordNotFoundException(Constants.PERSON_NOT_FOUND_WITH_PERSON_ID + personId+ ","+emailId));
        if(!Objects.isNull(personEntity.get().getEmails())) {
            personEntity.get().getEmails().removeIf(item -> item.getEmailId().equals(emailId));
        }
        personRepository.deleteById(emailId);
    }
}

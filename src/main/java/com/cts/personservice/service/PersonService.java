package com.cts.personservice.service;


import com.cts.personservice.constant.Constants;
import com.cts.personservice.entity.PersonEntity;
import com.cts.personservice.entity.PersonSearchEntity;
import com.cts.personservice.exception.RecordNotFoundException;
import com.cts.personservice.model.*;
import com.cts.personservice.repository.PersonRepository;
import com.cts.personservice.service.converter.PersonConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.cts.personservice.util.EncodingUtils.decodeVersion;
import static com.cts.personservice.util.EncodingUtils.encodeVersion;

@Service
public class PersonService {

    private static final Logger LOG = LoggerFactory.getLogger(PersonService.class);

    private final PersonConverter personConverter;
    private final PersonRepository personRepository;

    public PersonService(PersonConverter personConverter, PersonRepository personRepository) {
        this.personConverter = personConverter;
        this.personRepository = personRepository;
    }

    public String createPerson(Person person) {
        LOG.info("Creating person");
        PersonEntity personEntity = personConverter.personModelToEntity(person);
        personRepository.save(personEntity);
        return personEntity.getPersonId();
    }

    public ModelHolder<Person> getPerson(String personId) {
        LOG.info(Constants.GETTING_PERSON_WITH_PERSON_ID, personId);
        Optional<PersonEntity> personEntity = personRepository.findById(personId);
        personEntity.orElseThrow(() -> new RecordNotFoundException(Constants.PERSON_NOT_FOUND_WITH_PERSON_ID + personId));
        Person person = personConverter.personEntityToModel(personEntity.get());
        return new ModelHolder<Person>(person, encodeVersion(personEntity.get().getVersion()));
    }

    public String updatePerson(String personId, String ifMatch, PersonBase personBase) {
        LOG.info(Constants.UPDATING_PERSON_WITH_PERSON_ID, personId, decodeVersion(ifMatch));
        Optional<PersonEntity> personEntity = personRepository.findById(personId);
        personEntity.orElseThrow(() -> new RecordNotFoundException(Constants.PERSON_NOT_FOUND_WITH_PERSON_ID + personId));
        PersonEntity mergedPersonEntity = null;
        personRepository.save(mergedPersonEntity);
        return encodeVersion(mergedPersonEntity.getVersion());
    }

    public void deletePerson(String personId) {
        LOG.info(Constants.DELETING_PERSON_WITH_PERSON_ID, personId);
        Optional<PersonEntity> personEntity = personRepository.findById(personId);
        personEntity.orElseThrow(() -> new RecordNotFoundException(Constants.PERSON_NOT_FOUND_WITH_PERSON_ID + personId));
        personRepository.deleteById(personId);
    }

    public PersonSearchResponse searchPersons(PersonSearch personSearch) {
        PersonSearchEntity personSearchEntity = personConverter.personSearchModelToEntity(personSearch);
        List<PersonEntity> persons = personRepository.searchPerson(personSearchEntity);
        LOG.info(Constants.TOTAL_RESULTS, persons.size());
        return new PersonSearchResponse()
                .withDataCount(persons.size())
                .withPersons(personConverter.personsEntityToModel(persons))
                .build();
    }
}

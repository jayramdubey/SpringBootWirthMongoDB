package com.cts.personservice.repository;

import com.cts.personservice.constant.Constants;
import com.cts.personservice.entity.PersonEntity;
import com.cts.personservice.entity.PersonSearchEntity;
import com.cts.personservice.repository.build.PersonSearchQueryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class PersonRepositoryCustomImpl implements PersonRepositoryCustom{

    private static final Logger LOG = LoggerFactory.getLogger(PersonRepositoryCustomImpl.class);

    private final MongoTemplate mongoTemplate;

    public PersonRepositoryCustomImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public List<PersonEntity> searchPerson(PersonSearchEntity personSearchEntity) {
        List<PersonEntity> personEntities = Collections.emptyList();
        Optional<Query> query = buildPersonSearchQuery(personSearchEntity);
        if(!query.isPresent()){
            LOG.info(Constants.NO_QUERY_PARAMETER_FOUND);
        }else{
            personEntities = mongoTemplate.find(query.get(),PersonEntity.class);
        }
        return personEntities;
    }

    private Optional<Query> buildPersonSearchQuery(PersonSearchEntity personSearchEntity) {
        return new PersonSearchQueryBuilder()
                .withFirstName(personSearchEntity)
                .withMiddleName(personSearchEntity)
                .withLastName(personSearchEntity)
                .build();
    }
}

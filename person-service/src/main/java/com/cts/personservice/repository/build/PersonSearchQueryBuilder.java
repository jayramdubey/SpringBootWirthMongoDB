package com.cts.personservice.repository.build;

import com.cts.personservice.entity.PersonSearchEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.Optional;

import static org.apache.commons.lang3.StringUtils.isEmpty;

public class PersonSearchQueryBuilder {

    private static final Logger LOG = LoggerFactory.getLogger(PersonSearchQueryBuilder.class);

    private Query query;
    private boolean validQuery;

    public PersonSearchQueryBuilder() {
        this.query = new Query();
    }

    public Optional<Query> build(){
        if(validQuery){
            return Optional.ofNullable(query);
        }
        return Optional.empty();
    }

    public PersonSearchQueryBuilder withFirstName(PersonSearchEntity personSearch){
        if(!isEmpty(personSearch.getFirstName())){
            validQuery = true;
            LOG.info("First Name is present in this person search request.So adding it to mongo query");
            query.addCriteria(Criteria.where("nameEntity.firstName").is(personSearch.getFirstName()));
        }
        return this;
    }

    public PersonSearchQueryBuilder withMiddleName(PersonSearchEntity personSearch){
        if(!isEmpty(personSearch.getMiddleName())){
            validQuery = true;
            LOG.info("Middle Name is present in this person search request.So adding it to mongo query");
            query.addCriteria(Criteria.where("nameEntity.middleName").is(personSearch.getMiddleName()));
        }
        return this;
    }

    public PersonSearchQueryBuilder withLastName(PersonSearchEntity personSearch){
        if(!isEmpty(personSearch.getLastName())){
            validQuery = true;
            LOG.info("Last Name is present in this person search request.So adding it to mongo query");
            query.addCriteria(Criteria.where("nameEntity.lastName").is(personSearch.getLastName()));
        }
        return this;
    }

    //TODO : add for email and phone ,address
}

package com.cts.personservice.repository;

import com.cts.personservice.entity.PersonEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends MongoRepository<PersonEntity,String>,PersonRepositoryCustom {

}

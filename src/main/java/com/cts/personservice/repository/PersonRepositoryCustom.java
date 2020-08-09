package com.cts.personservice.repository;

import com.cts.personservice.entity.PersonEntity;
import com.cts.personservice.entity.PersonSearchEntity;

import java.util.List;

public interface PersonRepositoryCustom{

    List<PersonEntity> searchPerson(PersonSearchEntity personSearchEntity);
}

package com.cts.personservice.model;

import java.time.LocalDateTime;
import java.util.List;

import static java.util.Objects.isNull;

public class PersonSearchResponse {

    private Integer dataCount;
    private LocalDateTime localDateTime;
    private List<Person> persons;


    public PersonSearchResponse build(){
        this.localDateTime = LocalDateTime.now();
        return this;
    }

    public PersonSearchResponse withDataCount(Integer dataCount){
        this.dataCount = !isNull(dataCount)? dataCount : 0;
        return this;
    }

    public PersonSearchResponse withPersons(List<Person> persons){
        this.persons = persons;
        return this;
    }

    public Integer getDataCount() {
        return dataCount;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public List<Person> getPersons() {
        return persons;
    }
}

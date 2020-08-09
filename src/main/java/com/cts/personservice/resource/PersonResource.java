package com.cts.personservice.resource;


import com.cts.personservice.constant.Constants;
import com.cts.personservice.model.*;
import com.cts.personservice.service.PersonService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/v1/persons")
@Api("Set of endpoints for Creating, Retrieving, Updating and Deleting Persons.")
public class PersonResource {

    private static final Logger LOG = LoggerFactory.getLogger(PersonResource.class);

    private final PersonService personService;

    public PersonResource(PersonService personService) {
        this.personService = personService;
    }

    //1.Create Person
    @ApiOperation("Creates a new person")
    @PostMapping(value = "/person")
    public ResponseEntity<String> createPerson(@Valid @RequestBody Person person,
                                               @RequestHeader(value = "X-Tenant-Id",required = false) String tenantId) {
        String personId = personService.createPerson(person);
        LOG.info(Constants.PERSON_CREATED_SUCCESSFULLY, personId);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(personId);
    }

    //2.Get Person
    @ApiOperation("Get a person.404 if the person's identifier is not found")
    @GetMapping(value = "/{personId}")
    public ResponseEntity<Person> getPerson(@PathVariable String personId,
                                            @RequestHeader(value = "X-Tenant-Id",required = false) String tenantId) {
        ModelHolder<Person> holder = personService.getPerson(personId);
        LOG.info(Constants.PERSON_GET_IS_SUCCESSFUL, personId);
        return ResponseEntity.status(HttpStatus.OK)
                .eTag(holder.getVersion())
                .body(holder.getBody());
    }

    //3.Update Person
    @ApiOperation("Update a person. 404 if the person's identifier is not found.")
    @PutMapping(value = "/{personId}")
    public ResponseEntity<Void> updatePerson(@PathVariable String personId,
                                             @RequestBody PersonBase personBase,
                                             @RequestHeader(value = "If-Match") String ifMatch,
                                             @RequestHeader(value = "X-Tenant-Id",required = false) String tenantId) {
        String version = personService.updatePerson(personId, ifMatch, personBase);
        LOG.info(Constants.PERSON_UPDATE_IS_SUCCESSFUL, personId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT)
                .eTag(version)
                .build();
    }

    //4.Delete Person
    @ApiOperation("Delete a person. 404 if the persons's identifier is not found.")
    @DeleteMapping(value = "/{personId}")
    public ResponseEntity<Void> deletePerson(@PathVariable String personId,
                                             @RequestHeader(value = "X-Tenant-Id",required = false) String tenantId) {
        personService.deletePerson(personId);
        LOG.info(Constants.PERSON_DELETE_IS_SUCCESSFUL, personId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT)
                .build();
    }

    //4.Search Person
    @ApiOperation("Search persons.")
    @PostMapping
    public ResponseEntity<PersonSearchResponse> searchPersons(@RequestBody PersonSearch personSearch,
                                                              @RequestHeader(value = "X-Tenant-Id") String tenantId) {
        PersonSearchResponse response = personService.searchPersons(personSearch);
        LOG.info(Constants.TOTAL_NUMBER_OF_PERSON_FOUND, response.getDataCount());
        return ResponseEntity.status(HttpStatus.OK)
                .body(response);
    }
}

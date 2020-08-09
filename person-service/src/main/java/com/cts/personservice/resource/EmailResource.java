package com.cts.personservice.resource;


import com.cts.personservice.constant.Constants;
import com.cts.personservice.model.*;
import com.cts.personservice.service.EmailService;
import com.cts.personservice.service.PersonService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/v1/persons/{personId}/email")
@Api("Set of endpoints for Creating, Retrieving, Updating and Deleting Email.")
public class EmailResource {

    private static final Logger LOG = LoggerFactory.getLogger(EmailResource.class);

    private final EmailService emailService;

    public EmailResource(EmailService emailService)
    {
        this.emailService = emailService;
    }

    //1.Create Person
    @ApiOperation("Creates a new email")
    @PostMapping(value = "/email")
    public ResponseEntity<String> createPerson(@Valid @PathVariable String personId,
                                                   @RequestBody List<EmailAddress> emailAddress,
                                               @RequestHeader(value = "X-Tenant-Id",required = false) String tenantId) {
        String emailCreate = emailService.createEmail(personId, emailAddress);
        LOG.info(Constants.PERSON_CREATED_SUCCESSFULLY, personId);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(personId);
    }
    //4.Delete Person
    @ApiOperation("Delete a person Email. 404 if the Person's identifier is not found.")
    @DeleteMapping(value = "/{emailId}")
    public ResponseEntity<Void> deleteEmail(@PathVariable String personId,
                                             @PathVariable String emailId,
                                             @RequestHeader(value = "X-Tenant-Id",required = false) String tenantId) {
        emailService.deleteEmail(personId, emailId);
        LOG.info(Constants.PERSON_DELETE_IS_SUCCESSFUL, personId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT)
                .build();
    }


}

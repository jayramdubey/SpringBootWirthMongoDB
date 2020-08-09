package com.cts.personservice.service.validation.validator;

import com.cts.personservice.service.validation.ValidationContext;

@FunctionalInterface
public interface Validator {

    void validate(ValidationContext context);

    default boolean shouldRun(ValidationContext context){
        return true;
    }
}

package com.cts.personservice.service.validation;

import com.cts.personservice.service.validation.validator.Validator;

import java.util.List;
import java.util.Optional;

public class ValidationChain {

    private List<Validator> validators;

    public ValidationChain(List<Validator> validators) {
        this.validators = validators;
    }

    public void execute(ValidationContext context) {
        Optional.ofNullable(validators)
                .ifPresent(validators -> {
                            validators.stream()
                                    .filter(validator -> validator.shouldRun(context))
                                    .forEachOrdered(validator -> validator.validate(context));
                        }

                );
    }
}

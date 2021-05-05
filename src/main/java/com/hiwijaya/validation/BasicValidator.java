package com.hiwijaya.validation;

import javax.validation.*;
import java.util.Set;

/**
 * @author Happy Indra Wijaya
 */
public class BasicValidator {

    public <B> boolean isValid(B b){

        //Create ValidatorFactory which returns validator
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        //Validate bean
        Set<ConstraintViolation<B>> violations = validator.validate(b);

        return violations.isEmpty();
    }

}

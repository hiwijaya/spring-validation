package com.hiwijaya.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

/**
 * @author Happy Indra Wijaya
 */
@Service
public class ValidationService {

    @Autowired
    private Validator validator;


    public <B> boolean basicValidate(B b){

        //Create ValidatorFactory which returns validator
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();

        //It validates bean instances
        validator = factory.getValidator();

        //Validate bean
        Set<ConstraintViolation<B>> constraintViolations = validator.validate(b);

        //Show errors
        if (constraintViolations.size() > 0) {
            for (ConstraintViolation<B> violation : constraintViolations) {
                System.out.println(violation.getMessage());
            }
            return false;
        }

        return true;

    }

    public <B> boolean springValidate(B b){

        //Validate bean
        Set<ConstraintViolation<B>> constraintViolations = validator.validate(b);

        //Show errors
        if (constraintViolations.size() > 0) {
            for (ConstraintViolation<B> violation : constraintViolations) {
                System.out.println(violation.getMessage());
            }
            return false;
        }

        return true;

    }



}

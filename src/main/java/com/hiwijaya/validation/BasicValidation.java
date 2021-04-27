package com.hiwijaya.validation;

import javax.validation.*;
import java.time.LocalDate;
import java.time.Month;
import java.util.Set;

/**
 * @author Happy Indra Wijaya
 */
public class BasicValidation {


    public <B> boolean isValid(B b){

        //Create ValidatorFactory which returns validator
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();

        Validator validator = factory.getValidator();

        //Validate bean
        Set<ConstraintViolation<B>> violations = validator.validate(b);

        if (!violations.isEmpty()) {
            throw new ConstraintViolationException(violations);
        }

        return true;
    }


    public static void main(String[] args) {

        // TODO: move it to unit test.

        Person person = Person.builder()
                .name("Happy Indra Wijaya")
                .email("me@hiwijaya.com")
                .age(23)
                .birthDay(LocalDate.of(1992, Month.JULY, 10))
                .working(true)
                .build();

        BasicValidation validation = new BasicValidation();

        if(validation.isValid(person)){
            System.out.println("Object valid");
        }

    }

}

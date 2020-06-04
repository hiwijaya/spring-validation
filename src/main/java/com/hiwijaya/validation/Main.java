package com.hiwijaya.validation;


import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.time.LocalDate;
import java.time.Month;
import java.util.Date;
import java.util.Set;

/**
 * @author Happy Indra Wijaya
 */
public class Main {

    private void basicValidation(){

        Person person = Person.builder()
                .name("Happy Indra Wijaya")
                .email("me@hiwijaya.com")
                .age(15)
                .birthDay(LocalDate.of(1992, Month.JULY, 10))
                .working(false)
                .build();

        //Create ValidatorFactory which returns validator
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();

        //It validates bean instances
        Validator validator = factory.getValidator();

        //Validate bean
        Set<ConstraintViolation<Person>> constraintViolations = validator.validate(person);

        //Show errors
        if (constraintViolations.size() > 0) {
            for (ConstraintViolation<Person> violation : constraintViolations) {
                System.out.println(violation.getMessage());
            }
        } else {
            System.out.println("Valid Object");
        }


    }

    public static void main(String[] args) {

        Main main = new Main();

        main.basicValidation();



    }

}

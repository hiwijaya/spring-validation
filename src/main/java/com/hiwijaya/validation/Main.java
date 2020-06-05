package com.hiwijaya.validation;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import java.time.LocalDate;
import java.time.Month;

/**
 * @author Happy Indra Wijaya
 */
public class Main {



    public static void main(String[] args) {

        Person person = Person.builder()
                .name("Happy Indra Wijaya")
                .email("me@hiwijaya.com")
                .age(15)
                .birthDay(LocalDate.of(1992, Month.JULY, 10))
                .working(false)
                .build();

        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        ValidationService validationService = context.getBean(ValidationService.class);

        //boolean isValid = validationService.basicValidate(person);
        boolean isValid = validationService.springValidate(person);
        if(isValid){
            System.out.println("Object valid");
        }
        else{
            System.out.println("Object not valid");
        }


    }

}

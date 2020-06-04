package com.hiwijaya.validation;

import lombok.Builder;

import javax.validation.constraints.*;
import java.time.LocalDate;

/**
 * @author Happy Indra Wijaya
 */
@Builder
public class Person {

    @Size(min = 3, message = "Invalid name")
    @NotEmpty(message = "Name cannot be empty")
    private String name;

    @Email(message = "Please input a valid format email")
    private String email;

    @Max(value = 50, message = "Age should not be greater than 50")
    @Min(value = 17, message = "Age should not be less than 17")
    @Positive
    private int age;

    @Past(message = "birthday is past")
    private LocalDate birthDay;    // should use LocalDate instead of old java.util.Date

    @AssertTrue(message = "You should have a job.")
    private boolean working;


}

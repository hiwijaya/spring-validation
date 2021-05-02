package com.hiwijaya.validation;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;

/**
 * @author Happy Indra Wijaya
 */
@DisplayName("Basic Validation Test")
public class BasicValidationTest {

    private BasicValidation basicValidation = new BasicValidation();

    @Test
    public void testValidateSuccess(){

        Input input = Input.builder()
                .name("Happy Indra Wijaya")
                .email("me@hiwijaya.com")
                .age(29)
                .birthDay(LocalDate.of(1992, Month.JULY, 10))
                .working(true)
                .ipAddress("192.168.0.1")
                .build();

        var result = basicValidation.isValid(input);
        assertTrue(result);

    }

    @Test
    public void testValidateFailed(){

        Input input = Input.builder()
                .name("Happy Indra Wijaya")
                .email("me@hiwijaya.com")
                .age(17)
                .birthDay(LocalDate.of(1992, Month.JULY, 10))
                .working(true)
                .ipAddress("192.168.0.1")
                .build();

        var result = basicValidation.isValid(input);
        assertTrue(result);

    }



}

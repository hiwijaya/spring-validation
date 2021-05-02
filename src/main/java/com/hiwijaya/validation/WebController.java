package com.hiwijaya.validation;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

/**
 * @author Happy Indra Wijaya
 */
@RestController
@Validated
public class WebController {

    @PostMapping("/validate-body")
    public ResponseEntity<String> validateRequestBody(@Valid @RequestBody Input input){
        return ResponseEntity.ok("valid");
    }

    @GetMapping("/validate-path-variable/{id}")
    public ResponseEntity<String> validatePathVariable(@PathVariable("id") @Min(1) int id){
        return ResponseEntity.ok("valid");
    }

    @GetMapping("/validate-request-parameter")
    public ResponseEntity<String> validateRequestParameter(@RequestParam("id") @Max(10) int id){
        return ResponseEntity.ok("valid");
    }

}

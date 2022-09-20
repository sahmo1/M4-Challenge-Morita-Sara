package com.example.utilityapi.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

@RestController
public class CalculatorController {

    public CalculatorController() {
    }

    @RequestMapping(value = "/calculator/divide", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public double divide(@RequestParam int value1, @RequestParam int value2) {

        //gracefully handles division by zero
        if (value2 == 0) {
            //throw new IllegalArgumentException("Cannot divide by zero");
            return 0.0;
        }
        
        return value1 / value2;
    }

    @RequestMapping(value = "/calculator/square/{value}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public int square(@PathVariable @Valid int value) {

        //gracefully handles square that exceeds maximum integer value of 2147483647

        long square = (long)value * (long)value;
        if (square > 46340) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Exceeded maximum integer value of 2147483647");
        }

        return value * value;
    }
}

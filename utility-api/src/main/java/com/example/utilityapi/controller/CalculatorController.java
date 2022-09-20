package com.example.utilityapi.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class CalculatorController {

    public CalculatorController() {
    }

    @RequestMapping(value = "/calculator/divide", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public double divide(@RequestParam int value1, @RequestParam int value2) {

        //gracefully handles division by zero
        if (value2 == 0) {
            throw new IllegalArgumentException("Cannot divide by zero");
        }

        /*
        else if (value2 != 0) {
            return value1 / value2;
        }
        */
        
        return value1 / value2;
    }

    @RequestMapping(value = "/calculator/square/{value}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public int square(@PathVariable int value) {

        //gracefully handles square that exceeds maximum integer value of 2147483647
        if (value > 46340) {
            throw new IllegalArgumentException("Value exceeds maximum integer value");
        }
        /*
        else if (value <= 46340) {
            return value * value;
        }
        */

        return value * value;
    }
}

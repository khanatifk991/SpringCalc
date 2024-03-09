package com.example.additionservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdditionController {

    @GetMapping("/add")
    public String addNumbers(@RequestParam(value = "a") int a, @RequestParam(value = "b") int b) {
        int sum = a + b;
        return "The sum of " + a + " and " + b + " is " + sum;
    }
}

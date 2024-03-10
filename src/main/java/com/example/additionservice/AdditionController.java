package com.example.additionservice;

import org.springframework.web.bind.annotation.*;

@RestController
public class AdditionController {

    @GetMapping("/add")
    public String addNumbers(@RequestParam(value = "a") int a, @RequestParam(value = "b") int b) {
        int sum = a + b;
        return "The sum of " + a + " and " + b + " is " + sum;
    }

    @PostMapping("/subtract")
    public String subtractNumbers(@RequestBody NumbersRequest numbersRequest) {
        int result = numbersRequest.getFirstNumber() - numbersRequest.getSecondNumber();
        return "The result of subtracting " + numbersRequest.getSecondNumber() + " from " +
                numbersRequest.getFirstNumber() + " is " + result;
    }

    @PostMapping("/multiply")
    public String multiplyNumbers(@RequestBody NumbersRequest numbersRequest) {
        int result = numbersRequest.getFirstNumber() * numbersRequest.getSecondNumber();
        return "The result of multiplying " + numbersRequest.getFirstNumber() + " and " +
                numbersRequest.getSecondNumber() + " is " + result;
    }

    @PostMapping("/divide")
    public String divideNumbers(@RequestBody NumbersRequest numbersRequest) {
        if (numbersRequest.getSecondNumber() == 0) {
            return "Error: Division by zero is not allowed";
        }
        double result = (double) numbersRequest.getFirstNumber() / numbersRequest.getSecondNumber();
        return "The result of dividing " + numbersRequest.getFirstNumber() + " by " +
                numbersRequest.getSecondNumber() + " is " + result;
    }
    @PutMapping("/updateFirstNumber/{value}")
    public String updateFirstNumber(@PathVariable int value) {
         firstNumber.setfirstNumber(value);
        return "Number first updated to " + value;
    }


}

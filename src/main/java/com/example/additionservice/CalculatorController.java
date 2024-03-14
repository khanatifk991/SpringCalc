package com.example.additionservice;

import org.springframework.web.bind.annotation.*;

@RestController
public class CalculatorController {

    @GetMapping("/add")
    public String addNumbers(@RequestParam(value = "a") int a, @RequestParam(value = "b") int b) {
        int sum = a + b;
        return String.format("The sum of %d and %d is %d", a, b, sum);
    }

    @PostMapping("/subtract")
    public String subtractNumbers(@RequestBody NumbersRequest numbersRequest) {
        int result = numbersRequest.getFirstNumber() - numbersRequest.getSecondNumber();
        return String.format("The result of subtracting %d from %d is %d",
                numbersRequest.getSecondNumber(), numbersRequest.getFirstNumber(), result);
    }

    @PostMapping("/multiply")
    public String multiplyNumbers(@RequestBody NumbersRequest numbersRequest) {
        int result = numbersRequest.getFirstNumber() * numbersRequest.getSecondNumber();
        return String.format("The result of multiplying %d and %d is %d",
                numbersRequest.getFirstNumber(), numbersRequest.getSecondNumber(), result);
    }

    @PostMapping("/divide")
    public String divideNumbers(@RequestBody NumbersRequest numbersRequest) {
        if (numbersRequest.getSecondNumber() == 0) {
            return "Error: Division by zero is not allowed";
        }
        double result = (double) numbersRequest.getFirstNumber() / numbersRequest.getSecondNumber();
        return String.format("The result of dividing %d by %d is %f",
                numbersRequest.getFirstNumber(), numbersRequest.getSecondNumber(), result);
    }
    @PutMapping("/updateFirstNumber/{value}")
    public String updateFirstNumber(@PathVariable int value) {
         FirstNumber.setFirstNumber(value);
         return String.format("Number first updated to %d", value);
    }


}

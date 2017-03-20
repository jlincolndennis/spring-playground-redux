package com.example;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/math")
public class MathEndpointController {

    @GetMapping("/pi")
    public String getPi(){
        return "3.141592653589793";
    }

    @GetMapping("/calculate")
    public String getCalculationFromQueryStrings(@RequestParam(defaultValue = "add") String operation,
                                                 @RequestParam int x,
                                                 @RequestParam int y){
        int solution = 0;
        String operator = "+";
        switch (operation) {
            case "add":
                solution = x + y;
                operator = "+";
                break;
            case "subtract":
                solution = x - y;
                operator = "-";
                break;
            case "multiply":
                solution = x * y;
                operator = "*";
                break;
            case "divide":
                solution = x / y;
                operator = "/";
                break;
        }
        return String.format("%d %s %d = %d", x, operator, y, solution);
    }


}

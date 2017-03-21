package com.example;

import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.ListIterator;

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
        return MathService.calculate(operation, x, y);
    }

    @GetMapping("/sum")
    public String getSumFromQueryString(@RequestParam MultiValueMap<String, String> numbers){
        return MathService.sum(numbers);
    }

    @RequestMapping("/volume/{length}/{width}/{height}")
    public String volumeFromPathVariables(Cuboid cuboid){
        cuboid.setVolume();
        return String.format("The volume of a %dx%dx%d rectangle is %d", cuboid.getLength(),
                                                                         cuboid.getWidth(),
                                                                         cuboid.getHeight(),
                                                                         cuboid.getVolume());
    }


}

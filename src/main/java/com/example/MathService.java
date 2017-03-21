package com.example;

import org.springframework.util.MultiValueMap;

import java.util.List;
import java.util.ListIterator;

public class MathService {

    public static String calculate(String operation, int x, int y){
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

    public static String sum(MultiValueMap<String, String> numbers){
        StringBuilder statement = new StringBuilder();
        int solution = 0;
        List<String> numberSet = numbers.get("n");
        ListIterator<String> numberIterator = numberSet.listIterator();

        for (String n : numberSet){
            int number = Integer.parseInt(n);

            solution +=number;
            statement.append(number);
            statement.append(" ");
            numberIterator.next();

            if(numberIterator.hasNext()){
                statement.append("+ ");
            }
        }

        statement.append("= ");
        statement.append(solution);

        return statement.toString();

    }


}

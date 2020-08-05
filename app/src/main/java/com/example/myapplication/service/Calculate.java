package com.example.myapplication.service;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BinaryOperator;

public class Calculate {

    private final Map<String, BinaryOperator<Double>> operations;

    public Calculate() {
        this.operations = new HashMap<>();
        operations.put("+", (aDouble, aDouble2) -> aDouble + aDouble2);
        operations.put("-", (aDouble, aDouble2) -> aDouble - aDouble2);
        operations.put("*", (aDouble, aDouble2) -> aDouble * aDouble2);
        operations.put("/", (aDouble, aDouble2) -> aDouble / aDouble2);
    }

    public double calculate(String num1, String num2, String operation) {
        double number1 = Double.parseDouble(num1);
        double number2 = Double.parseDouble(num2);
        return operations.get(operation).apply(number1,number2);
    }
}

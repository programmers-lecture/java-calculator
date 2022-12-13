package controller;

import model.CalculatorType;

import java.util.HashMap;
import java.util.Map;

public class Calculator {

    private static Map<String, CalculatorType> calculatorTypeMap = new HashMap<>();

    static {
        for (CalculatorType value : CalculatorType.values())
            calculatorTypeMap.put(value.getOperator(), value);
    }
    public static double calculate(String operator, double left, double right) {
        return calculatorTypeMap.get(operator).calculate(left, right);
    }
}

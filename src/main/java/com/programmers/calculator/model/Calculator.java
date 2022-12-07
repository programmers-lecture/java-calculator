package com.programmers.calculator.model;

public class Calculator {
    public int calculate(String[] expressions) {
        Operation operation = new Operation();
        int result = operation.toInt(expressions[0]);

        for (int i = 0; i < expressions.length; i++) {
            if (expressions[i].equals("+")) {
                result = operation.add(result, operation.toInt(expressions[i + 1]));
            } else if (expressions[i].equals("-")) {
                result = operation.minus(result, operation.toInt(expressions[i + 1]));
            } else if (expressions[i].equals("*")) {
                result = operation.multiple(result, operation.toInt(expressions[i + 1]));
            } else if (expressions[i].equals("/")) {
                result = operation.divide(result, operation.toInt(expressions[i + 1]));
            }
        }
        return result;
    }
}
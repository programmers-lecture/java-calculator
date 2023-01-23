package application.calculator;

import java.util.function.BiFunction;

public enum Operator {
    ADDITION("+", (num1, num2) -> num1 + num2),
    SUBTRACTION("-", (num1, num2) -> num1 - num2),
    MULTIPLICATION("*", (num1, num2) -> num1 * num2),
    DIVISION("/", (num1, num2) -> num1 / num2);

    private final String operatorAsString;
    private final BiFunction<Double, Double, Double> calculation;

    Operator(String operatorAsString, BiFunction<Double, Double, Double> calculation) {
        this.operatorAsString = operatorAsString;
        this.calculation = calculation;
    }

    public BiFunction<Double, Double, Double> getCalculation() {
        return calculation;
    }

    public String getOperatorAsString() {
        return operatorAsString;
    }
}
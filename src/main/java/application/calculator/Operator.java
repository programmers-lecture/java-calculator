package application.calculator;

import java.util.Arrays;
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
    public static Operator findOperator(String str) {
        return Arrays.stream(Operator.values())
                .filter(operator -> operator.operatorAsString.equals(str))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException());
    }
    public BiFunction<Double, Double, Double> getCalculation() {
        return calculation;
    }
}
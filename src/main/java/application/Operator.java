package application;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum Operator {
    ADD("+", (operand1, operand2) -> operand1 + operand2),
    SUB("-", (operand1, operand2) -> operand1 - operand2),
    MUL("*", (operand1, operand2) -> operand1 * operand2),
    DIV("/", (operand1, operand2) -> operand1 / operand2);

    private String operator;
    private BiFunction<Double, Double, Double> expression;

    Operator(String operator, BiFunction<Double, Double, Double> expression) {
        this.operator = operator;
        this.expression = expression;
    }

    public static Operator getOperator(String operator) {
        return Arrays.stream(values())
                .filter(obj -> obj.operator.equals(operator))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(Message.NOT_FOUND_OPERATOR));
    }

    public static double calculate(String operator, double operand1, double operand2) {
        return getOperator(operator).expression.apply(operand1, operand2);
    }

}

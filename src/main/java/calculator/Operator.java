package calculator;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum Operator {
    ADDITION("+", (operand1, operand2) -> operand1 + operand2),
    SUBTRACTION("-", (operand1, operand2) -> operand1 - operand2),
    MULTIPLICATION("*", (operand1, operand2) -> operand1 * operand2),
    DIVISION("/", (operand1, operand2) -> operand1 / operand2);

    private String operator;
    private BiFunction<Integer, Integer, Integer> expression;

    Operator(String operator, BiFunction<Integer, Integer, Integer> expression) {
        this.operator = operator;
        this.expression = expression;
    }

    public static Operator getOperator(String operator) {
        return Arrays.stream(values())
                .filter(operation -> operation.operator.equals(operator))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("연산자 없음"));
    }

    public static int calculate(String operator, Integer operand1, Integer operand2) {
        return getOperator(operator).expression.apply(operand1, operand2);
    }
}
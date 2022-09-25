package calculator.domain;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum Operator {
    PLUS(Calculator.PLUS_OPERATOR, (startOperand, endOperand) -> startOperand + endOperand),
    MINUS(Calculator.MINUS_OPERATOR, (startOperand, endOperand) -> startOperand - endOperand),
    MULTIPLY(Calculator.MULTIPLY_OPERATOR, (startOperand, endOperand) -> startOperand * endOperand),
    DIVIDE(Calculator.DIVIDE_OPERATOR, (startOperand, endOperand) -> {
        if (endOperand == 0) {
            throw new IllegalArgumentException("0으로 나눌 수 없습니다.");
        }
        return startOperand / endOperand;
    });
    private String operator;
    private BiFunction<Integer, Integer, Integer> expression;


    Operator(String operator, BiFunction<Integer, Integer, Integer> expression) {
        this.operator = operator;
        this.expression = expression;
    }

    public static String calculate(String operator, int startOperand, int endOperand) {
        return String.valueOf(
                getOperator(operator).getExpression().apply(startOperand, endOperand));
    }

    private static Operator getOperator(String operator) {
        return Arrays.stream(values())
                .filter(i -> i.operator.equals(operator))
                .findFirst().get();
    }

    private BiFunction<Integer, Integer, Integer> getExpression() {
        return expression;
    }
}
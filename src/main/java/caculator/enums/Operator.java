package caculator.enums;

import java.util.Arrays;
import java.util.function.BinaryOperator;

public enum Operator {
    PLUS("+", 1, (firstOperand, secondOperand) -> firstOperand + secondOperand ),
    MINUS("-", 1, (firstOperand, secondOperand) -> firstOperand - secondOperand ),
    MULTIPLY("*", 2, (firstOperand, secondOperand) -> firstOperand * secondOperand ),
    DIVIDE("/", 2, (firstOperand, secondOperand) -> {
        if(secondOperand == 0)
            throw new IllegalArgumentException("0으로 나눌 수 없습니다.");
        return firstOperand / secondOperand;
    });

    private final String operator;
    private final Integer priority;
    private final BinaryOperator<Double> expression;

    Operator(String operator, Integer priority, BinaryOperator<Double> expression) {
        this.operator = operator;
        this.priority = priority;
        this.expression = expression;
    }

    public static Operator findOperator(String value) {
        return Arrays.stream(values())
                .filter(op -> op.operator.equals(value))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("연산자를 찾을 수 없습니다."));
    }

    public static boolean isOperator(String operator) {
        return Arrays.stream(values())
                .anyMatch(op -> op.operator.equals(operator));
    }

    public Double operate(Double firstOperand, Double secondOperand) {
        return expression.apply(firstOperand, secondOperand);
    }

    public boolean isLowPriority(Operator operator) {
        return this.priority <= operator.priority;
    }
}

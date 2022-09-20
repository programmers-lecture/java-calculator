package caculator.enums;

import java.util.function.BiFunction;

public enum Operator {
    PLUS("+", 1, (firstOperand, secondOperand) -> firstOperand + secondOperand ),
    MINUS("-", 1, (firstOperand, secondOperand) -> firstOperand - secondOperand ),
    MULTIPLY("*", 2, (firstOperand, secondOperand) -> firstOperand * secondOperand ),
    DIVIDE("/", 2, (firstOperand, secondOperand) -> {
        if(secondOperand == 0)
            throw new RuntimeException("0으로 나눌 수 없습니다.");
        return firstOperand / secondOperand;
    });

    private final String operator;
    private final Integer priority;
    private final BiFunction<Double, Double, Double> expression;

    Operator(String operator, Integer priority, BiFunction<Double, Double, Double> expression) {
        this.operator = operator;
        this.priority = priority;
        this.expression = expression;
    }

    public static Operator findOperator(String value) {
        if(value.equals(PLUS.getOperator()))
            return PLUS;
        if(value.equals(MINUS.getOperator()))
            return MINUS;
        if(value.equals(MULTIPLY.getOperator()))
            return MULTIPLY;
        if(value.equals(DIVIDE.getOperator()))
            return DIVIDE;
        throw new IllegalArgumentException();
    }

    public String getOperator() {
        return operator;
    }

    public Integer getPriority() {
        return priority;
    }

    public Double operate(Double firstOperand, Double secondOperand) {
        return expression.apply(firstOperand, secondOperand);
    }
}

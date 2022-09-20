package caculator.enums;

import java.util.function.BiFunction;

public enum Operator {
    PLUS("+", (firstOperand, secondOperand) -> firstOperand + secondOperand ),
    MINUS("-", (firstOperand, secondOperand) -> firstOperand - secondOperand ),
    MULTIPLY("*", (firstOperand, secondOperand) -> firstOperand * secondOperand ),
    DIVIDE("/", (firstOperand, secondOperand) -> {
        if(secondOperand == 0)
            throw new RuntimeException("0으로 나눌 수 없습니다.");
        return firstOperand / secondOperand;
    });

    private final String operator;
    private final BiFunction<Double, Double, Double> expression;

    Operator(String operator, BiFunction<Double, Double, Double> expression) {
        this.operator = operator;
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

    public Double operate(Double firstOperand, Double secondOperand) {
        return expression.apply(firstOperand, secondOperand);
    }
}

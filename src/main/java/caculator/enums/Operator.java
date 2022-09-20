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
    private final BiFunction<Integer, Integer, Integer> expression;

    Operator(String operator, BiFunction<Integer, Integer, Integer> expression) {
        this.operator = operator;
        this.expression = expression;
    }


    public Integer operate(Integer firstOperand, Integer secondOperand) {
        return expression.apply(firstOperand, secondOperand);
    }
}

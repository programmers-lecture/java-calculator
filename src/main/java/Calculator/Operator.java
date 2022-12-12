package Calculator;

import java.util.function.BiFunction;

public enum Operator {
    ADD("+", (first, second) -> first + second),
    SUBTRACT("-", (first, second) -> first - second),
    MULTIPLY("*", (first, second) -> first * second),
    DIVIDE("/", (first, second) -> {
        if (second == 0) {
            throw new ArithmeticException("0으로 나눌 수 없습니다.");
        }
        return first / second;
    });

    private String symbol;
    private BiFunction<Integer, Integer, Integer> expression;

    Operator(String symbol, BiFunction<Integer, Integer, Integer> expression) {
        this.symbol = symbol;
        this.expression = expression;
    }
    public int operate(int first, int second) {
        return expression.apply(first, second);
    }

    public static Operator findOperator(String symbol) {
        for (Operator operator: Operator.values()) {
            if (operator.symbol.equals(symbol)) {
                return operator;
            }
        }
        throw new IllegalArgumentException("+, -, *, / 연산자가 아닙니다.");
    }
}

package domain;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.BiFunction;

public enum Operator {

    PLUS("+", (a, b) -> a + b),
    MINUS("-", (a, b) -> a - b),
    MULTIPLY("*", (a, b) -> a * b),
    DIVIDE("/", (a, b) -> a / b);

    private static final Map<String, Operator> MY_OPERATOR = new HashMap<>();

    static {
        Arrays.stream(Operator.values())
                .forEach(operator -> MY_OPERATOR.put(operator.type, operator));
    }

    private final String type;
    private final BiFunction<Integer, Integer, Integer> biFunction;

    Operator(String type, BiFunction<Integer, Integer, Integer> biFunction) {
        this.type = type;
        this.biFunction = biFunction;
    }

    public static Operator checkOperator(String operatorType) {
        return Optional.ofNullable(MY_OPERATOR.get(operatorType)).orElseThrow();
    }

    public Integer calculate(Integer a, Integer b) {
        return this.biFunction.apply(a, b);
    }
}

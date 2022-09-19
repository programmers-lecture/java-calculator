package operator;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.BiFunction;

public enum Operator {

    LEFT_BRACKET("(", 0, (a, b) -> 0),
    RIGHT_BRACKET(")", 0, (a, b) -> 0),
    PLUS("+",1, (a, b) -> a + b),
    MINUS("-",1, (a, b) -> a - b),
    MULTIPLY("*",2, (a, b) -> a * b),
    DIVIDE("/",2, (a, b) -> a / b);

    private static Map<String, Operator> MY_OPERATOR = new HashMap<>();

    static {
        Arrays.stream(Operator.values())
                .forEach(operator -> MY_OPERATOR.put(operator.type, operator));
    }

    private final String type;
    private final int priority;

    private final BiFunction<Integer, Integer, Integer> biFunction;

    Operator(String type, int priority, BiFunction<Integer, Integer, Integer> biFunction) {
        this.type = type;
        this.priority = priority;
        this.biFunction = biFunction;
    }

    public static Operator getOperator(String operatorType) {
        return Optional.ofNullable(MY_OPERATOR.get(operatorType)).orElseThrow();
    }

    public static boolean checkOperator(String operatorType) {
        return Optional.ofNullable(MY_OPERATOR.get(operatorType)).isPresent();
    }

    public static Integer calculate(Integer a, String operatorType, Integer b) {
        return getOperator(operatorType).calculate(a, b);
    }
    public static boolean checkNotBracket(Operator operator) {
        return operator != LEFT_BRACKET && operator != RIGHT_BRACKET;
    }

    public static boolean checkLeftBracket(Operator operator) {
        return operator == LEFT_BRACKET;
    }

    public static boolean checkRightBracket(Operator operator) {
        return operator == RIGHT_BRACKET;
    }


    public Integer calculate(Integer a, Integer b) {
        return this.biFunction.apply(a, b);
    }

    public int getPriority() {
        return priority;
    }

    public String getType() {
        return type;
    }
}

package stringcalculator.operator;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.BiFunction;

import static java.lang.Character.isDigit;

public enum Operator {

    LEFT_BRACKET("(", 0, (a, b) -> 0),
    RIGHT_BRACKET(")", 0, (a, b) -> 0),
    PLUS("+",1, (a, b) -> a + b),
    MINUS("-",1, (a, b) -> a - b),
    MULTIPLY("*",2, (a, b) -> a * b),
    DIVIDE("/",2, (a, b) -> a / b);

    private static final Map<String, Operator> MY_OPERATOR = new HashMap<>();

    static {
        Arrays.stream(Operator.values())
                .forEach(operator -> MY_OPERATOR.put(operator.type, operator));
    }

    private final String type;
    private final int priority;

    private final BiFunction<Integer, Integer, Integer> simpleCalculator;

    Operator(String type, int priority, BiFunction<Integer, Integer, Integer> simpleCalculator) {
        this.type = type;
        this.priority = priority;
        this.simpleCalculator = simpleCalculator;
    }

    public static Operator getOperator(String operatorType) {
        return Optional.ofNullable(MY_OPERATOR.get(operatorType)).orElseThrow();
    }

    public static boolean checkOperator(String operatorType) {
        return Optional.ofNullable(MY_OPERATOR.get(operatorType)).isPresent();
    }

    public static Integer calculate(Integer operandLeft, String operator, Integer operandRight) {
        return getOperator(operator).calculate(operandLeft, operandRight);
    }

    public static boolean checkLeftBracket(Operator operator) {
        return Optional.ofNullable(operator)
                .orElseThrow(NullPointerException::new) == LEFT_BRACKET;
    }

    public static boolean checkRightBracket(Operator operator) {
        return Optional.ofNullable(operator)
                .orElseThrow(NullPointerException::new) == RIGHT_BRACKET;
    }

    public static boolean checkDigit(String value) {
        return isDigit(Optional.ofNullable(value).orElseThrow().charAt(0));
    }


    public Integer calculate(Integer operandLeft, Integer operandRight) {
        return this.simpleCalculator.apply(operandLeft, operandRight);
    }

    public int getPriority() {
        return priority;
    }
}

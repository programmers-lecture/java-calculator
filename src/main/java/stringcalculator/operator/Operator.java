package stringcalculator.operator;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.BiFunction;

import static java.lang.Character.isDigit;

public enum Operator {

    LEFT_BRACKET("(", 0, (operandLeft, operandRight) -> 0),
    RIGHT_BRACKET(")", 0, (operandLeft, operandRight) -> 0),
    PLUS("+",1, (operandLeft, operandRight) -> operandLeft + operandRight),
    MINUS("-",1, (operandLeft, operandRight) -> operandLeft - operandRight),
    MULTIPLY("*",2, (operandLeft, operandRight) -> operandLeft * operandRight),
    DIVIDE("/",2, (operandLeft, operandRight) -> operandLeft / operandRight);

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
        return Optional.ofNullable(MY_OPERATOR
                .get(operatorType))
                .orElseThrow(() -> new NullPointerException("확인되지 않은 연산자 입니다."));
    }

    public static boolean checkOperator(String operatorType) {
        return Optional.ofNullable(MY_OPERATOR
                .get(operatorType))
                .isPresent();
    }

    public static Integer calculate(Integer operandLeft, String operator, Integer operandRight) {
        return getOperator(operator).calculate(operandLeft, operandRight);
    }

    public static boolean checkLeftBracket(Operator operator) {
        return Optional.ofNullable(operator)
                .orElseThrow(
                        () -> new NullPointerException("확인되지 않은 연산자 입니다.")
                ) == LEFT_BRACKET;
    }

    public static boolean checkRightBracket(Operator operator) {
        return Optional.ofNullable(operator)
                .orElseThrow(
                        () -> new NullPointerException("확인되지 않은 연산자 입니다.")
                ) == RIGHT_BRACKET;
    }

    public static boolean checkDigit(String value) {
        return isDigit(Optional
                .ofNullable(value)
                .orElseThrow(() -> new NullPointerException("확인되지 않은 연산자 입니다."))
                .charAt(0)
                );
    }

    public Integer calculate(Integer operandLeft, Integer operandRight) {
        return this.simpleCalculator.apply(operandLeft, operandRight);
    }

    public int getPriority() {
        return priority;
    }
}

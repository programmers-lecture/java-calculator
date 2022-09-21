package stringcalculator.operator;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.IntBinaryOperator;
import java.util.stream.Stream;

import static java.lang.Character.isDigit;

public enum Operator {

    LEFT_BRACKET("(", 0, (operandLeft, operandRight) -> 0),
    RIGHT_BRACKET(")", 0, (operandLeft, operandRight) -> 0),
    PLUS("+", 1, (operandLeft, operandRight) -> operandLeft + operandRight),
    MINUS("-", 1, (operandLeft, operandRight) -> operandLeft - operandRight),
    MULTIPLY("*", 2, (operandLeft, operandRight) -> operandLeft * operandRight),
    DIVIDE("/", 2, (operandLeft, operandRight) -> operandLeft / operandRight);

    private final String type;
    private final int priority;
    private final IntBinaryOperator simpleCalculator;

    Operator(String type, int priority, IntBinaryOperator simpleCalculator) {
        this.type = type;
        this.priority = priority;
        this.simpleCalculator = simpleCalculator;
    }

    public static Operator getOperator(String operatorType) {
        return findOperator(operatorType)
                .orElseThrow(() -> new NullPointerException("확인되지 않은 연산자 입니다."));
    }

    public static boolean checkOperator(String operatorType) {
        return findOperator(operatorType).isPresent();
    }

    private static Optional<Operator> findOperator(String operatorType) {
        return Arrays.stream(values())
                .filter(operator -> operator.type.equals(operatorType))
                .findAny();
    }

    public static int calculate(int operandLeft, String operator, int operandRight) {
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

    public static boolean checkDigit(String formula) {
        return isDigit(getFormulaAfterCheckNull(formula).charAt(0));
    }

    public static String getFormulaAfterCheckNull(String formula) {
        return Optional
                .ofNullable(formula)
                .orElseThrow(() -> new NullPointerException("확인되지 않은 연산자 입니다."));
    }

    public int calculate(int operandLeft, int operandRight) {
        return this.simpleCalculator.applyAsInt(operandLeft, operandRight);
    }

    public int getPriority() {
        return priority;
    }
}

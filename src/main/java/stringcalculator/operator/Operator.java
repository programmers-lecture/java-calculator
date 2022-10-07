package stringcalculator.operator;

import java.util.Arrays;
import java.util.Optional;
import java.util.function.IntBinaryOperator;

import static java.lang.Character.isDigit;
import static stringcalculator.exception.ExceptionMessage.DIVIDE_ZERO_ERROR;
import static stringcalculator.exception.ExceptionMessage.FORMULA_NULL_ERROR;

public enum Operator {

    LEFT_BRACKET("(", 0, (operandLeft, operandRight) -> 0),
    RIGHT_BRACKET(")", 0, (operandLeft, operandRight) -> 0),
    PLUS("+", 1, (operandLeft, operandRight) -> operandLeft + operandRight),
    MINUS("-", 1, (operandLeft, operandRight) -> operandLeft - operandRight),
    MULTIPLY("*", 2, (operandLeft, operandRight) -> operandLeft * operandRight),
    DIVIDE("/", 2, (operandLeft, operandRight) -> {
        if (operandRight == 0) {
            throw new IllegalArgumentException(DIVIDE_ZERO_ERROR.getMessage());
        }
        return operandLeft / operandRight;
    });

    private final String type;
    private final int priority;
    private final IntBinaryOperator simpleCalculator;

    Operator(String type, int priority, IntBinaryOperator simpleCalculator) {
        this.type = type;
        this.priority = priority;
        this.simpleCalculator = simpleCalculator;
    }

    public static Operator findOperator(String operatorType) {
        return findOptionalOperator(operatorType)
                .orElseThrow(() -> new NullPointerException(FORMULA_NULL_ERROR.getMessage()));
    }

    public static boolean checkOperator(String operatorType) {
        return findOptionalOperator(operatorType).isPresent();
    }

    public static int calculate(int operandLeft, String operator, int operandRight) {
        return findOperator(operator).calculate(operandLeft, operandRight);
    }

    public static boolean checkLeftBracket(Operator operator) {
        return Optional.ofNullable(operator)
                .orElseThrow(() -> new NullPointerException(FORMULA_NULL_ERROR.getMessage()))
                == LEFT_BRACKET;
    }

    public static boolean checkRightBracket(Operator operator) {
        return Optional.ofNullable(operator)
                .orElseThrow(() -> new NullPointerException(FORMULA_NULL_ERROR.getMessage()))
                == RIGHT_BRACKET;
    }

    public static boolean checkDigit(String formula) {
        return isDigit(getFormulaAfterCheckNull(formula).charAt(0));
    }

    public static boolean checkPriorityBiggerThan(Operator operatorLeft, Operator operatorRight) {
        return operatorLeft.priority >= operatorRight.priority;
    }

    private static Optional<Operator> findOptionalOperator(String operatorType) {
        return Arrays.stream(values())
                .parallel()
                .filter(operator -> operator.type.equals(operatorType))
                .findAny();
    }

    private static String getFormulaAfterCheckNull(String formula) {
        return Optional
                .ofNullable(formula)
                .orElseThrow(() -> new NullPointerException(FORMULA_NULL_ERROR.getMessage()));
    }

    private int calculate(int operandLeft, int operandRight) {
        return this.simpleCalculator.applyAsInt(operandLeft, operandRight);
    }

    public String getType() {
        return type;
    }
}

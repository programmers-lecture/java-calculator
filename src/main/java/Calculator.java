import java.util.Arrays;

public class Calculator {
    private Integer prevNumber;
    private Integer operand;
    private Operator operator;

    private static final String NOT_NUMBER = "숫자가 아닙니다.";

    public Calculator(Integer prevNumber, String operand, String operation) {
        this.prevNumber = prevNumber;
        this.operand = validateNumber(operand);
        this.operator = validateOperator(operation);
    }

    private Integer validateNumber(String a) {
        try {
            return Integer.parseInt(a);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_NUMBER);
        }
    }

    private Operator validateOperator(String operation) {
        return operator.findOperation(operation);
    }

    public Integer calculateNumber() {
        return operator.calculate(prevNumber, operand);
    }
}

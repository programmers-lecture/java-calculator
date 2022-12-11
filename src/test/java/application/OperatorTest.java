package application;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OperatorTest {
    @Test
    public void 더하기_Test() {
        String operator = "+";
        Double operand1 = new Double(3);
        Double operand2 = new Double(5);

        assertEquals(8, Operator.calculate(operator, operand1, operand2));
    }
    @Test
    public void 빼기_Test() {
        String operator = "-";
        Double operand1 = new Double(3);
        Double operand2 = new Double(5);

        assertEquals(-2, Operator.calculate(operator, operand1, operand2));
    }
    @Test
    public void 곱하기_Test() {
        String operator = "*";
        Double operand1 = new Double(3);
        Double operand2 = new Double(5);

        assertEquals(15, Operator.calculate(operator, operand1, operand2));
    }
    @Test
    public void 나누기_Test() {
        String operator = "/";
        Double operand1 = new Double(10);
        Double operand2 = new Double(5);

        assertEquals(2, Operator.calculate(operator, operand1, operand2));
    }
}

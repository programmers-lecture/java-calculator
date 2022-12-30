package application;

import org.junit.jupiter.api.Test;

import static application.Calculator.toDouble;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {
    @Test
    public void 계산기_Test() {
        String expression = "1 + 2 - 3 + 4";
        String[] parsing = expression.split(" ");

        Double result = toDouble(parsing[0]);

        for(int i=1; i<parsing.length; i += 2) {
            String operator = parsing[i];
            Double operand = toDouble(parsing[i+1]);
            result = Operator.calculate(operator, result, operand);
        }

        assertEquals(4, result);
    }

    @Test
    public void 우선순위_Test() {
        String expression = "1 + 2 * 3";
        String[] parsing = expression.split(" ");

        Double result = toDouble(parsing[0]);

        for(int i=1; i<parsing.length; i += 2) {
            String operator = parsing[i];
            Double operand = toDouble(parsing[i+1]);
            result = Operator.calculate(operator, result, operand);
        }

        assertEquals(7, result);
    }
}

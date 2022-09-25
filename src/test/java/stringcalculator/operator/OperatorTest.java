package stringcalculator.operator;

import stringcalculator.operator.Operator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static stringcalculator.operator.Operator.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class OperatorTest {

    @Test
    @DisplayName("연산자 찾기 테스트")
    void getOperatorTest() {
        Operator checkPlus = getOperator("+");
        Operator checkMinus = getOperator("-");
        Operator checkMultiply = getOperator("*");
        Operator checkDivide = getOperator("/");

        assertEquals(PLUS, checkPlus);
        assertEquals(MINUS, checkMinus);
        assertEquals(MULTIPLY, checkMultiply);
        assertEquals(DIVIDE, checkDivide);
    }

    @Test
    @DisplayName("연산 테스트")
    void calculateTest() {

        Integer plusAnswer = PLUS.calculate(10, 2);
        Integer minusAnswer = MINUS.calculate(10, 2);
        Integer multiplyAnswer = MULTIPLY.calculate(10, 2);
        Integer divideAnswer = DIVIDE.calculate(10, 2);

        assertEquals(12, plusAnswer);
        assertEquals(8, minusAnswer);
        assertEquals(20, multiplyAnswer);
        assertEquals(5, divideAnswer);
    }

}
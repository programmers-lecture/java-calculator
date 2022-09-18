package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static domain.Operator.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class OperatorTest {

    @Test
    @DisplayName("연산자 찾기 테스트")
    void checkOperatorTest() {
        Operator checkPlus = checkOperator("+");
        Operator checkMinus = checkOperator("-");
        Operator checkMultiply = checkOperator("*");
        Operator checkDivide = checkOperator("/");

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
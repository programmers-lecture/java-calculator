package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SignTest {

    @Test
    @DisplayName("문자열에서 Sign ADD 객체를 정상적으로 생성한다.")
    void getAddInstanceFromSignStrTest() {
        Sign add = Sign.fromSignStr("+");
        assertEquals(Sign.ADD, add);
    }

    @Test
    @DisplayName("문자열에서 Sign SUBTRACT 객체를 정상적으로 생성한다.")
    void getSubtractInstanceFromSignStrTest() {
        Sign subtract = Sign.fromSignStr("-");
        assertEquals(Sign.SUBTRACT, subtract);
    }

    @Test
    @DisplayName("문자열에서 Sign MULTIPLY 객체를 정상적으로 생성한다.")
    void getMultiplyInstanceFromSignStrTest() {
        Sign multiply = Sign.fromSignStr("*");
        assertEquals(Sign.MULTIPLY, multiply);
    }

    @Test
    @DisplayName("문자열에서 Sign DIVIDE 객체를 정상적으로 생성한다.")
    void getDivideInstanceFromSignStrTest() {
        Sign divide = Sign.fromSignStr("/");
        assertEquals(Sign.DIVIDE, divide);
    }

    @Test
    @DisplayName("잘못된 문자에서 Sign 객체를 생성하고자 하면 예외가 발생한다.")
    void getSignInstanceFromAbnormalStringWillThrowException() {
        assertThrows(IllegalArgumentException.class,
                ()-> Sign.fromSignStr("a"));
    }

    @Test
    @DisplayName("우선순위가 높은 연산자인 경우 true 를 반환한다.")
    void isPrimalTest() {
        assertTrue(Sign.MULTIPLY.isPrimal());
        assertTrue(Sign.DIVIDE.isPrimal());
        assertFalse(Sign.ADD.isPrimal());
        assertFalse(Sign.SUBTRACT.isPrimal());
    }
}
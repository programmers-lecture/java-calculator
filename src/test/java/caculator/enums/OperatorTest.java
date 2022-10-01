package caculator.enums;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;
import static caculator.enums.Operator.*;

public class OperatorTest {

    static Stream<Arguments> getParametersForSuccessFindOperatorTest() {
        return Stream.of(
                Arguments.arguments("+", PLUS),
                Arguments.arguments("-", MINUS),
                Arguments.arguments("*", MULTIPLY),
                Arguments.arguments("/", DIVIDE)
        );
    }

    @ParameterizedTest(name = "연산자 텍스트 : {0}, 해당되는 Operator 클래스 반환 결과 : {1}")
    @DisplayName("연산자에 해당하는 글자로 연산자 찾기 성공 테스트")
    @MethodSource("getParametersForSuccessFindOperatorTest")
    void findOperatorSuccessTest(String operatorStr, Operator expected) {
        Operator actual = findOperator(operatorStr);
        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest(name = "strings: 연산자에 해당하지 않는 글자들")
    @DisplayName("연산자에 해당하지 않는 글자로 연산자 찾기 실패 테스트")
    @ValueSource(strings = {"연산자아님", "(", ")", ","})
    void findOperatorFailTestByNotOperatorStr(String noneOperatorStr) {
        assertThatIllegalArgumentException().isThrownBy(() -> findOperator(noneOperatorStr))
                .withMessage("연산자를 찾을 수 없습니다.");
    }

    @ParameterizedTest(name = "strings: 연산자에 해당하는 글자들")
    @DisplayName("연산자에 해당하는 글자로 연산자인지 여부 판단 성공 테스트")
    @ValueSource(strings = {"+", "-", "*", "/"})
    void isOperatorSuccessTest(String operatorStr) {
        boolean actual = isOperator(operatorStr);
        assertThat(actual).isTrue();
    }

    @ParameterizedTest(name = "strings: 연산자에 해당하지 않는 글자들")
    @DisplayName("연산자에 해당하는 글자로 연산자인지 여부 판단 실패 테스트")
    @ValueSource(strings = {"연산자아님", "(", ")", ","})
    void isOperatorFailTestByNotOperatorStr(String noneOperatorStr) {
        boolean actual = isOperator(noneOperatorStr);
        assertThat(actual).isFalse();
    }

    static Stream<Arguments> getParametersForSuccessIsLowPriorityTest() {
        return Stream.of(
                Arguments.arguments(PLUS, PLUS, true),
                Arguments.arguments(PLUS, MINUS, true),
                Arguments.arguments(PLUS, MULTIPLY, true),
                Arguments.arguments(PLUS, DIVIDE, true),
                Arguments.arguments(MINUS, PLUS, true),
                Arguments.arguments(MINUS, MINUS, true),
                Arguments.arguments(MINUS, MULTIPLY, true),
                Arguments.arguments(MINUS, DIVIDE, true),
                Arguments.arguments(MULTIPLY, PLUS, false),
                Arguments.arguments(MULTIPLY, MINUS, false),
                Arguments.arguments(MULTIPLY, MULTIPLY, true),
                Arguments.arguments(MULTIPLY, DIVIDE, true),
                Arguments.arguments(DIVIDE, PLUS, false),
                Arguments.arguments(DIVIDE, MINUS, false),
                Arguments.arguments(DIVIDE, MULTIPLY, true),
                Arguments.arguments(DIVIDE, DIVIDE, true)
        );
    }

    @ParameterizedTest(name = "{0} 이 {1} 보다 낮거나 같은 우선순위의 연산자인지에 따라 결과 {2}")
    @DisplayName("연산자 우선순위 판단 테스트")
    @MethodSource("getParametersForSuccessIsLowPriorityTest")
    void isLowPrioritySuccessTest(Operator operator1, Operator operator2, boolean expected) {
        boolean actual = operator1.isLowPriority(operator2);
        assertThat(actual).isEqualTo(expected);
    }

    static Stream<Arguments> getParametersForSuccessOperateTest() {
        return Stream.of(
                Arguments.arguments(PLUS, 10.0, 2.0, 12.0),
                Arguments.arguments(MINUS, 10.0, 2.0, 8.0),
                Arguments.arguments(MULTIPLY, 10.0, 2.0, 20.0),
                Arguments.arguments(DIVIDE, 10.0, 2.0, 5.0)
        );
    }

    @ParameterizedTest(name = "연산자 {0} 에 따라 {1} 과 {2} 를 계산한 결과 {3}")
    @DisplayName("연산자 계산 테스트")
    @MethodSource("getParametersForSuccessOperateTest")
    void operateTest(Operator operator, double number1, double number2, double expected) {
        double actual = operator.operate(number1, number2);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("0으로 나눠서 연산자 계산 실패 테스트")
    void operateFailTestByZeroDivide() {
        assertThatIllegalArgumentException().isThrownBy(() -> DIVIDE.operate(10.0, 0.0))
                        .withMessage("0으로 나눌 수 없습니다.");
    }
}

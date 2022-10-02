package stringcalculator.operator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.lang.String.valueOf;
import static org.assertj.core.api.Assertions.*;
import static stringcalculator.exception.ExceptionEnum.DIVIDE_ZERO_ERROR;
import static stringcalculator.exception.ExceptionEnum.FORMULA_NULL_ERROR;
import static stringcalculator.operator.Operator.*;

class OperatorTest {

    @ParameterizedTest(name = "[{index}] 연산자 {0}, 결과 = {1}")
    @MethodSource("getOperatorsToTestWhenFindOperatorThenSuccess")
    @DisplayName("연산자 문자 검색 성공 테스트")
    void whenStringOperatorThenSuccessTest(String operator, Operator result) {
        assertThat(findOperator(operator)).isEqualTo(result);
    }

    static Stream<Arguments> getOperatorsToTestWhenFindOperatorThenSuccess() {
        return Stream.of(
                Arguments.arguments("+", PLUS),
                Arguments.arguments("-", MINUS),
                Arguments.arguments("*", MULTIPLY),
                Arguments.arguments("/", DIVIDE),
                Arguments.arguments("(", LEFT_BRACKET),
                Arguments.arguments(")", RIGHT_BRACKET)
        );
    }

    @ParameterizedTest(name = "[{index}] 검색 기호 {0}")
    @MethodSource("getSignsToTestWhenWrongOperatorThenThrowException")
    @DisplayName("올바르지 않은 기호 연산시 예외처리 테스트")
    void whenNotOperatorThenThrowExceptionTest(String sign) {
        assertThatExceptionOfType(RuntimeException.class)
                .as("Test sign %s", sign)
                .isThrownBy(() -> findOperator(sign))
                .withMessage(FORMULA_NULL_ERROR.getCode() + " :: " + FORMULA_NULL_ERROR.getDesc());
    }

    static Stream<Arguments> getSignsToTestWhenWrongOperatorThenThrowException() {
        return IntStream.rangeClosed(33, 126)
                .filter(OperatorTest::checkAsciiCodeNotOperator)
                .mapToObj(OperatorTest::getSignsWithoutOperator);
    }

    static Arguments getSignsWithoutOperator(int ascii) {
        return Arguments.arguments(valueOf((char) ascii));
    }

    static boolean checkAsciiCodeNotOperator(int ascii) {
        return !List.of('(', ')', '+', '-', '*', '/').contains((char) ascii);
    }

    @ParameterizedTest(name = "[{index}] {0}이 {1} 보다 우선 수행됩니다.")
    @MethodSource("getOperatorsToTestWhenPriorityThenSuccess")
    @DisplayName("연산자 우선순위 성공 테스트")
    void whenPriorityComparesThenSuccessTest(
            Operator operatorLeft, Operator operatorRight, boolean isLeftImportant) {
        boolean findResult = checkPriorityBiggerThan(operatorLeft, operatorRight);
        assertThat(findResult).isEqualTo(isLeftImportant);
    }

    static Stream<Arguments> getOperatorsToTestWhenPriorityThenSuccess() {
        return Stream.of(
                Arguments.arguments(PLUS, PLUS, true),
                Arguments.arguments(PLUS, MINUS, true),
                Arguments.arguments(PLUS, MULTIPLY, false),
                Arguments.arguments(PLUS, DIVIDE, false),
                Arguments.arguments(PLUS, LEFT_BRACKET, true),
                Arguments.arguments(PLUS, RIGHT_BRACKET, true),
                Arguments.arguments(MINUS, PLUS, true),
                Arguments.arguments(MINUS, MINUS, true),
                Arguments.arguments(MINUS, MULTIPLY, false),
                Arguments.arguments(MINUS, DIVIDE, false),
                Arguments.arguments(MINUS, LEFT_BRACKET, true),
                Arguments.arguments(MINUS, RIGHT_BRACKET, true),
                Arguments.arguments(MULTIPLY, PLUS, true),
                Arguments.arguments(MULTIPLY, MINUS, true),
                Arguments.arguments(MULTIPLY, MULTIPLY, true),
                Arguments.arguments(MULTIPLY, DIVIDE, true),
                Arguments.arguments(MULTIPLY, LEFT_BRACKET, true),
                Arguments.arguments(MULTIPLY, RIGHT_BRACKET, true),
                Arguments.arguments(DIVIDE, PLUS, true),
                Arguments.arguments(DIVIDE, MINUS, true),
                Arguments.arguments(DIVIDE, MULTIPLY, true),
                Arguments.arguments(DIVIDE, DIVIDE, true),
                Arguments.arguments(DIVIDE, LEFT_BRACKET, true),
                Arguments.arguments(DIVIDE, RIGHT_BRACKET, true),
                Arguments.arguments(LEFT_BRACKET, PLUS, false),
                Arguments.arguments(LEFT_BRACKET, MINUS, false),
                Arguments.arguments(LEFT_BRACKET, MULTIPLY, false),
                Arguments.arguments(LEFT_BRACKET, DIVIDE, false),
                Arguments.arguments(LEFT_BRACKET, LEFT_BRACKET, true),
                Arguments.arguments(LEFT_BRACKET, RIGHT_BRACKET, true),
                Arguments.arguments(RIGHT_BRACKET, PLUS, false),
                Arguments.arguments(RIGHT_BRACKET, MINUS, false),
                Arguments.arguments(RIGHT_BRACKET, MULTIPLY, false),
                Arguments.arguments(RIGHT_BRACKET, DIVIDE, false),
                Arguments.arguments(RIGHT_BRACKET, LEFT_BRACKET, true),
                Arguments.arguments(RIGHT_BRACKET, RIGHT_BRACKET, true)
        );
    }

    @ParameterizedTest(name ="[{index}] 연산식 = {0} {1} {2}")
    @MethodSource("getFormulasToTestWhenDivideWithZeroThenThrowException")
    @DisplayName("0으로 나눴을 경우 예외처리 테스트")
    void whenDivideWithZeroThenThrowExceptionTest(int operandLeft, String operator, int operandRight) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Operator.calculate(operandLeft, operator, operandRight))
                .withMessage(DIVIDE_ZERO_ERROR.getDesc());
    }

    static Stream<Arguments> getFormulasToTestWhenDivideWithZeroThenThrowException() {
        return Stream.of(
                Arguments.arguments("0", "/", "0"),
                Arguments.arguments("1", "/", "0"),
                Arguments.arguments("2", "/", "0"),
                Arguments.arguments("3", "/", "0"),
                Arguments.arguments("4", "/", "0"),
                Arguments.arguments("5", "/", "0"),
                Arguments.arguments("1000", "/", "0")
        );
    }

    @ParameterizedTest(name = "[{index}] 연산식 {0} {1} {2} = {3}")
    @MethodSource("getOperatorsToTestWhenCalculateThenSuccess")
    @DisplayName("연산식별 연산 성공 테스트")
    void whenOperatorThenCalculateSuccessTest(int operandLeft, String operator, int operandRight, int result) {
        int calculatedResult = calculate(operandLeft, operator, operandRight);
        assertThat(calculatedResult).isEqualTo(result);
    }

    static Stream<Arguments> getOperatorsToTestWhenCalculateThenSuccess() {
        return Stream.of(
                Arguments.arguments(10, "+", 2, 12),
                Arguments.arguments(10, "-", 2, 8),
                Arguments.arguments(10, "*", 2, 20),
                Arguments.arguments(10, "/", 2, 5)
        );
    }

}
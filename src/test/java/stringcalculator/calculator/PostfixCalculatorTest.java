package stringcalculator.calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.lang.String.valueOf;
import static org.assertj.core.api.Assertions.*;
import static stringcalculator.exception.ExceptionEnum.DIVIDE_ZERO_ERROR;
import static stringcalculator.exception.ExceptionEnum.FORMULA_NULL_ERROR;
import static stringcalculator.view.Reader.splitWithoutSpace;

class PostfixCalculatorTest {

    private final PostfixCalculator calculator = new PostfixCalculator();

    @ParameterizedTest(name = "[{index}] PLUS : 연산식 = {0} , 결과 = {1}")
    @MethodSource("getFormulasToTestWhenPlusThenSuccess")
    @DisplayName("후위 계산식 더하기 성공 테스트")
    void whenPlusThenSuccessTest(String formula, int answer) {
        int result = calculator.getResult(splitWithoutSpace(formula));
        assertThat(result).isEqualTo(answer);
    }

    static Stream<Arguments> getFormulasToTestWhenPlusThenSuccess() {
        return Stream.of(
                Arguments.arguments("1 + 1", 2),
                Arguments.arguments("10 + 1", 11),
                Arguments.arguments("100 + 10", 110),
                Arguments.arguments("1000 + 100", 1100),
                Arguments.arguments("10000 + 1000", 11000),
                Arguments.arguments("100000 + 10000", 110000),
                Arguments.arguments("1000000 + 100000", 1100000),
                Arguments.arguments("1 + 10", 11),
                Arguments.arguments("10 + 100", 110),
                Arguments.arguments("100 + 1000", 1100),
                Arguments.arguments("1000 + 10000", 11000),
                Arguments.arguments("10000 + 100000", 110000),
                Arguments.arguments("100000 + 1000000", 1100000)
        );
    }

    @ParameterizedTest(name = "[{index}] MINUS : 연산식 = {0} , 결과 = {1}")
    @MethodSource("getFormulasToTestWhenMinusThenSuccess")
    @DisplayName("후위 계산식 빼기 성공 테스트")
    void whenMinusThenSuccessTest(String formula, int answer) {
        int result = calculator.getResult(splitWithoutSpace(formula));
        assertThat(result).isEqualTo(answer);
    }

    static Stream<Arguments> getFormulasToTestWhenMinusThenSuccess() {
        return Stream.of(
                Arguments.arguments("1 - 1", 0),
                Arguments.arguments("10 - 1", 9),
                Arguments.arguments("100 - 10", 90),
                Arguments.arguments("1000 - 100", 900),
                Arguments.arguments("10000 - 1000", 9000),
                Arguments.arguments("100000 - 10000", 90000),
                Arguments.arguments("1000000 - 100000", 900000),
                Arguments.arguments("1 - 10", -9),
                Arguments.arguments("10 - 100", -90),
                Arguments.arguments("100 - 1000", -900),
                Arguments.arguments("1000 - 10000", -9000),
                Arguments.arguments("10000 - 100000", -90000),
                Arguments.arguments("100000 - 1000000", -900000)
        );
    }

    @ParameterizedTest(name = "[{index}] MULTIPLY : 연산식 = {0} , 결과 = {1}")
    @MethodSource("getFormulasToTestWhenMultiplyThenSuccess")
    @DisplayName("후위 계산식 곱하기 성공 테스트")
    void whenMultiplyThenSuccessTest(String formula, int answer) {
        int result = calculator.getResult(splitWithoutSpace(formula));
        assertThat(result).isEqualTo(answer);
    }

    static Stream<Arguments> getFormulasToTestWhenMultiplyThenSuccess() {
        return Stream.of(
                Arguments.arguments("1 * 1", 1),
                Arguments.arguments("10 * 1", 10),
                Arguments.arguments("100 * 10", 1000),
                Arguments.arguments("1000 * 100", 100000),
                Arguments.arguments("10000 * 1000", 10000000),
                Arguments.arguments("100000 * 10000", 1000000000),
                Arguments.arguments("1 * 10",  10),
                Arguments.arguments("10 * 100", 1000),
                Arguments.arguments("100 * 1000", 100000),
                Arguments.arguments("1000 * 10000", 10000000),
                Arguments.arguments("10000 * 100000", 1000000000)
        );
    }

    @ParameterizedTest(name = "[{index}] DIVIDE : 연산식 = {0} , 결과 = {1}")
    @MethodSource("getFormulasToTestWhenDivideThenSuccess")
    @DisplayName("후위 계산식 나누기 성공 테스트")
    void whenDivideThenSuccessTest(String formula, int answer) {
        int result = calculator.getResult(splitWithoutSpace(formula));
        assertThat(result).isEqualTo(answer);
    }

    static Stream<Arguments> getFormulasToTestWhenDivideThenSuccess() {
        return Stream.of(
                Arguments.arguments("10 / 1", 10),
                Arguments.arguments("100 / 10", 10),
                Arguments.arguments("1000 / 100", 10),
                Arguments.arguments("10000 / 1000", 10),
                Arguments.arguments("100000 / 10000", 10),
                Arguments.arguments("1000000 / 100000", 10),
                Arguments.arguments("1 / 10", 0),
                Arguments.arguments("10 / 100", 0),
                Arguments.arguments("100 / 1000", 0),
                Arguments.arguments("1000 / 10000", 0),
                Arguments.arguments("10000 / 100000", 0),
                Arguments.arguments("100000 / 1000000", 0)
        );
    }

    @ParameterizedTest(name ="[{index}] 연산식 = {0}, 결과 = {1}")
    @MethodSource("getFormulasToTestWhenComplicatedThenSuccess")
    @DisplayName("후위 계산식 복합 연산 성공 테스트")
    void whenComplicatedFormulaThenSuccessTest(String formula, int answer) {
        int result = calculator.getResult(splitWithoutSpace(formula));
        assertThat(result).isEqualTo(answer);
    }

    static Stream<Arguments> getFormulasToTestWhenComplicatedThenSuccess() {
        return Stream.of(
               Arguments.arguments("1123 + 10 - 2 - 0 * (10 / 10 * 10 - 20 / 20 * 10 / 1 + (10 * 10 - 10)) + 100000 + 12000 * 10 - 120000", 101131),
               Arguments.arguments("1123 + 10 - 2 + 2 + 2 - 4 - 0 * (10 / 10 * 10 - 20 / 20 * 10 / 1 + (10 * 10 - 10)) + 10000 * 10 + 12000 / 100 * 10 * 10 * 2 * 5 - 120000 / 10 * 10 / 2 / 5 * 10", 101131)
        );
    }

    @ParameterizedTest(name ="[{index}] 정리되지 않은 연산식 = {0}, 결과 = {1}")
    @MethodSource("getFormulasToTestWhenManySpacesThenSuccess")
    @DisplayName("정리되지 않은 후위 계산식 연산 성공 테스트")
    void whenManySpaceThenSuccessTest(String formula, int answer) {
        int result = calculator.getResult(splitWithoutSpace(formula));
        assertThat(result).isEqualTo(answer);
    }

    static Stream<Arguments> getFormulasToTestWhenManySpacesThenSuccess() {
        return Stream.of(
                Arguments.arguments("1                                        + (1 0 + 22 0 0 0 0 ) + 10", 220021),
                Arguments.arguments("1+    ( 1 0 + 2     2 0 0 00)+ 1  0", 220021),
                Arguments.arguments("1           + (1                 0 + 22 0 0 0 0 ) + 10", 220021),
                Arguments.arguments("  1       + (1 0 +2     2000    0 ) + 1      0  ", 220021)
        );
    }

    @ParameterizedTest(name ="[{index}] 0으로 나누는 연산식 = {0}")
    @MethodSource("getFormulasToTestWhenDivideWithZeroThenThrowException")
    @DisplayName("후위 계산식 0으로 나눴을 경우 예외처리 테스트")
    void whenDivideWithZeroThenThrowExceptionTest(String formula) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> calculator.getResult(splitWithoutSpace(formula)))
                .withMessage(DIVIDE_ZERO_ERROR.getDesc());
    }

    static Stream<Arguments> getFormulasToTestWhenDivideWithZeroThenThrowException() {
        return Stream.of(
                Arguments.arguments("0 / 0"),
                Arguments.arguments("1 / 0"),
                Arguments.arguments("2 / 0"),
                Arguments.arguments("3 / 0"),
                Arguments.arguments("4 / 0"),
                Arguments.arguments("10 + 10 / 0"),
                Arguments.arguments("10 + 10 - 10 / 0"),
                Arguments.arguments("20 / 10 / 0"),
                Arguments.arguments("20 * 10 / 0")
        );
    }

    @ParameterizedTest(name = "[{index}] 잘못된 입력 기호 = {0}")
    @MethodSource("getSignsToTestWhenWrongOperatorThenThrowException")
    @DisplayName("올바르지 않은 기호가 포함된 후위 계산식 실패 예외처리 테스트")
    void whenWrongOperatorThenThrowException(String operator) {
        assertThatExceptionOfType(RuntimeException.class)
                .as("Test operator =  %s", operator)
                .isThrownBy(() -> calculator.getResult(splitWithoutSpace(operator)))
                .withMessage(FORMULA_NULL_ERROR.getCode() + " :: " + FORMULA_NULL_ERROR.getDesc());
    }

    static Stream<Arguments> getSignsToTestWhenWrongOperatorThenThrowException() {
        return Stream.of(
                Arguments.arguments("!"),
                Arguments.arguments("@"),
                Arguments.arguments("#"),
                Arguments.arguments("$"),
                Arguments.arguments("%"),
                Arguments.arguments("^"),
                Arguments.arguments("&"),
                Arguments.arguments("_"),
                Arguments.arguments("="),
                Arguments.arguments("\\"),
                Arguments.arguments("|"),
                Arguments.arguments("||"),
                Arguments.arguments("~"),
                Arguments.arguments("`"),
                Arguments.arguments("'"),
                Arguments.arguments("\""),
                Arguments.arguments("["),
                Arguments.arguments("]"),
                Arguments.arguments("{"),
                Arguments.arguments("}"),
                Arguments.arguments(":"),
                Arguments.arguments(";"),
                Arguments.arguments(","),
                Arguments.arguments("."),
                Arguments.arguments("<"),
                Arguments.arguments(">"),
                Arguments.arguments("?")
        );
    }

    @ParameterizedTest(name = "[{index}] 잘못된 입력 기호 = {0}")
    @MethodSource("getAlphabetsToTestWhenWrongOperatorThenThrowException")
    @DisplayName("올바르지 않은 알파벳이 포함된 후위 계산식 실패 예외처리 테스트")
    void whenAlphaIsOperatorThenThrowException(String operator) {
        assertThatExceptionOfType(RuntimeException.class)
                .as("Test operator =  %s", operator)
                .isThrownBy(() -> calculator.getResult(splitWithoutSpace(operator)))
                .withMessage(FORMULA_NULL_ERROR.getCode() + " :: " + FORMULA_NULL_ERROR.getDesc());
    }

    static Stream<Arguments> getAlphabetsToTestWhenWrongOperatorThenThrowException() {
        return IntStream.rangeClosed(65, 122)
                .filter(Character::isAlphabetic)
                .mapToObj(PostfixCalculatorTest::getAlphabetArgument);
    }

    static Arguments getAlphabetArgument(int ascii) {
        return Arguments.arguments(valueOf((char) ascii));
    }

}
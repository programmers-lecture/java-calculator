package stringcalculator.converter;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.lang.String.valueOf;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static stringcalculator.exception.ExceptionEnum.FORMULA_NULL_ERROR;
import static stringcalculator.view.Reader.splitWithoutSpace;

class FormConverterTest {

    private final FormConverter converter = new FormConverter();

    @ParameterizedTest(name = "[{index}] 연산식 = {0}, 반환된 배열 결과 = {1}")
    @MethodSource("getInputFromToTestWhenFormConvertedThenSuccess")
    @DisplayName("사용자 입력 연산식 포맷 변환, 배열 결과 성공 테스트")
    void separateStringTest(String formula, String result) {
        List<String> convertedFormula = converter.getFormula(splitWithoutSpace(formula));
        assertThat(convertedFormula.toString()).isEqualTo(result);
    }

    static Stream<Arguments> getInputFromToTestWhenFormConvertedThenSuccess() {
        return Stream.of(
                Arguments.arguments("10 + 20", "[10, +, 20]"),
                Arguments.arguments("10 - 20", "[10, -, 20]"),
                Arguments.arguments("10 * 20", "[10, *, 20]"),
                Arguments.arguments("10 / 20", "[10, /, 20]"),
                Arguments.arguments(
                        "123 + 123 * 123 + (123 - 10 * 123 ( 10 + 10 + (20) / 2) /2 )",
                        "[123, +, 123, *, 123, +, (, (, 123, -, 10, *, 123, (, (, 10, +, 10, +, (, (, 20, ), ), /, 2, ), ), /, 2, ), )]"
                )
        );
    }

    @ParameterizedTest(name = "[{index}] 잘못된 입력 기호 = {0}")
    @MethodSource("getAlphabetsToTestWhenWrongOperatorThenThrowException")
    @DisplayName("올바르지 않은 알파벳이 포함된 연산식 실패 예외처리 테스트")
    void whenAlphaIsOperatorThenThrowException(String operator) {
        assertThatExceptionOfType(RuntimeException.class)
                .as("Test operator =  %s", operator)
                .isThrownBy(() -> converter.getFormula(splitWithoutSpace(operator)))
                .withMessage(FORMULA_NULL_ERROR.getCode() + " :: " + FORMULA_NULL_ERROR.getDesc());
    }

    static Stream<Arguments> getAlphabetsToTestWhenWrongOperatorThenThrowException() {
        return IntStream.rangeClosed(65, 122)
                .filter(Character::isAlphabetic)
                .mapToObj(FormConverterTest::getAlphabetArgument);
    }

    static Arguments getAlphabetArgument(int ascii) {
        return Arguments.arguments(valueOf((char) ascii));
    }

    @ParameterizedTest(name = "[{index}] 잘못된 입력 기호 = {0}")
    @MethodSource("getSignsToTestWhenWrongOperatorThenThrowException")
    @DisplayName("올바르지 않은 기호가 포함된 연산식 변환 실패 예외처리 테스트")
    void whenWrongOperatorThenThrowException(String operator) {
        assertThatExceptionOfType(RuntimeException.class)
                .as("Test operator =  %s", operator)
                .isThrownBy(() -> converter.getFormula(splitWithoutSpace(operator)))
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

}
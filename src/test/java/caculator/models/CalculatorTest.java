package caculator.models;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

public class CalculatorTest {

    private final Calculator calculator = new Calculator();

    static Stream<Arguments> getParametersForCalculateSuccessTest() {
        return Stream.of(
                Arguments.arguments(List.of("5", "4", "8", "*", "2", "/", "10", "-", "+"), 11.0)
        );
    }

    @ParameterizedTest(name = "알맞은 후위 표기식 계산식 {0}으로 계산한 결과 {1}")
    @DisplayName("알맞은 후위 표기식 계산식으로 계산 성공 테스트")
    @MethodSource("getParametersForCalculateSuccessTest")
    void calculateSuccessTest(List<String> postfixFormula, double expected) {
        double actual = calculator.calculate(postfixFormula);
        assertThat(actual).isEqualTo(expected);
    }

    static Stream<Arguments> getParametersForCalculateFailTestByLessThanPossibleMinNumberCount() {
        return Stream.of(
                Arguments.arguments(List.of("5", "4", "8", "*", "2", "/", "10", "-", "+", "+"))
        );
    }

    @ParameterizedTest(name = "연산자가 계산해야될 숫자보다 더 많은 후위 표기식 계산식 {0}")
    @DisplayName("연산자가 계산해야될 숫자보다 더 많은 후위 표기식 계산식으로 계산 실패 테스트")
    @MethodSource("getParametersForCalculateFailTestByLessThanPossibleMinNumberCount")
    void calculateFailTestByLessThanPossibleMinNumberCount(List<String> incorrectPostfixFormula) {
        assertThatIllegalArgumentException().isThrownBy(() ->
                        calculator.calculate(incorrectPostfixFormula))
                .withMessage("올바르지 않은 계산식입니다.");
    }

    static Stream<Arguments> getParametersForCalculateFailTestByMoreThanResultNumberCount() {
        return Stream.of(
                Arguments.arguments(List.of("5", "4", "8", "*", "2", "/", "10", "-", "+", "10"))
        );
    }

    @ParameterizedTest(name = "연산자보다 숫자가 더 많아서 결과로 하나의 숫자만 남지 않는 후위 표기식 계산식 {0}")
    @DisplayName("연산자보다 숫자가 더 많아서 결과로 하나의 숫자만 남지 않는 후위 표기식 계산식으로 계산 실패 테스트")
    @MethodSource("getParametersForCalculateFailTestByMoreThanResultNumberCount")
    void calculateFailTestByMoreThanResultNumberCount(List<String> incorrectPostfixFormula) {
        assertThatIllegalArgumentException().isThrownBy(() ->
                        calculator.calculate(incorrectPostfixFormula))
                .withMessage("올바르지 않은 계산식입니다.");
    }
}

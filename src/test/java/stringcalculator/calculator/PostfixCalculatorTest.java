package stringcalculator.calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;
import static stringcalculator.exception.ExceptionEnum.DIVIDE_ZERO_ERROR;
import static stringcalculator.exception.ExceptionEnum.FORMULA_NULL_ERROR;
import static stringcalculator.view.Reader.splitWithoutSpace;

class PostfixCalculatorTest {

    private final PostfixCalculator calculator = new PostfixCalculator();

    @ParameterizedTest
    @CsvSource({
            "1 + 3, 4",
            "10 + 10, 20",
            "525 + 475, 1000"})
    @DisplayName("더하기 테스트")
    void whenPlusThenResultTest(String formula, int answer) {
        int result = calculator.getResult(splitWithoutSpace(formula));
        assertThat(result).isEqualTo(answer);
    }

    @ParameterizedTest
    @CsvSource({
            "1 - 3, -2",
            "10 - 10, 0",
            "525 - 475, 50"})
    @DisplayName("빼기 테스트")
    void whenMinusThenResultTest(String formula, int answer) {
        int result = calculator.getResult(splitWithoutSpace(formula));
        assertThat(result).isEqualTo(answer);
    }

    @ParameterizedTest
    @CsvSource({
            "1 * 3, 3",
            "10 * 10, 100",
            "525 * 475, 249375"})
    @DisplayName("곱하기 테스트")
    void whenMultiplyThenResultTest(String formula, int answer) {
        int result = calculator.getResult(splitWithoutSpace(formula));
        assertThat(result).isEqualTo(answer);
    }

    @ParameterizedTest
    @CsvSource({
            "1 / 3, 0",
            "10 / 10, 1",
            "525 / 475, 1"})
    @DisplayName("나누기 테스트")
    void whenDivideThenResultTest(String formula, int answer) {
        int result = calculator.getResult(splitWithoutSpace(formula));
        assertThat(result).isEqualTo(answer);
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "1123 + 10 - 2 - 0 * (10 / 10 * 10 - 20 / 20 * 10 / 1 + (10 * 10 - 10)) + 100000 + 12000 * 10 - 120000",
            "1123 + 10 - 2 + 2 + 2 - 4 - 0 * (10 / 10 * 10 - 20 / 20 * 10 / 1 + (10 * 10 - 10)) + 10000 * 10 + 12000 / 100 * 10 * 10 * 2 * 5 - 120000 / 10 * 10 / 2 / 5 * 10"
    })
    @DisplayName("복잡한 연산 테스트")
    void whenComplicatedFormulaThenResultTest() {
        String formula =
                "1123 + 10 - 2 - 0 * (10 / 10 * 10 - 20 / 20 * 10 / 1 + (10 * 10 - 10)) + 100000 + 12000 * 10 - 120000";
        int result = calculator.getResult(splitWithoutSpace(formula));
        assertThat(result).isEqualTo(101131);
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "1                                        + (1 0 + 22 0 0 0 0 ) + 10",
            "1+    ( 1 0 + 2     2 0 0 00)+ 1  0",
            "1           + (1                 0 + 22 0 0 0 0 ) + 10",
            "1       + (1 0 +2     2000    0 ) + 1      0  "
    })
    @DisplayName("띄어쓰기 엉망 구별 테스트")
    void whenManySpaceThenResultTest(String formula) {
        int result = calculator.getResult(splitWithoutSpace(formula));
        assertThat(result).isEqualTo(220021);
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "1 / 0",
            "2 / 0",
            "10 / 0",
            "30 + 10 / 0",
            "20 * 10 - 10 * 10 / 0 * 10",
            "0 / 0",
    })
    @DisplayName("나누기 0 예외처리 테스트")
    void whenDivideWithZeroThenThrowExceptionTest(String formula) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> calculator.getResult(splitWithoutSpace(formula)))
                .withMessage(DIVIDE_ZERO_ERROR.getDesc());
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "10 ! 2",
            "10 @ 2",
            "10 # 2",
            "10 $ 2",
            "10 % 2",
            "10 ^ 2",
            "10 & 2",
            "10 _ 2",
            "10 = 2",
            "10 \\ 2",
            "10 | 2",
            "10 || 2",
            "10 ~ 2",
            "10 ` 2",
            "10 ' 2",
            "10 \" 2",
            "10 [ 2",
            "10 ] 2",
            "10 { 2",
            "10 } 2",
            "10 : 2",
            "10 ; 2",
            "10 , 2",
            "10 . 2",
            "10 < 2",
            "10 > 2",
            "10 ? 2"
    })
    @DisplayName("잘못된 문자 연산시에 예외처리 테스트")
    void whenWrongOperatorThenThrowException(String formula) {
        assertThatExceptionOfType(RuntimeException.class)
                .as("Test formula =  %s", formula)
                .isThrownBy(() -> calculator.getResult(splitWithoutSpace(formula)))
                .withMessage(FORMULA_NULL_ERROR.getCode() + " :: " + FORMULA_NULL_ERROR.getDesc());
    }

    @Test
    @DisplayName("잘못된 문자 연산시에 예외처리 테스트")
    void whenAlphaIsOperatorThenThrowException() {
        for (int formula = 65; formula <= 122; formula++) {
            String finalFormula = String.valueOf((char) formula);
            assertThatExceptionOfType(RuntimeException.class)
                    .as("Test formula =  %s", finalFormula)
                    .isThrownBy(() -> calculator.getResult(splitWithoutSpace(finalFormula)))
                    .withMessage(FORMULA_NULL_ERROR.getCode() + " :: " + FORMULA_NULL_ERROR.getDesc());
        }
    }

}
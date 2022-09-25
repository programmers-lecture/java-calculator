package stringcalculator.calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import stringcalculator.converter.FormConverter;
import stringcalculator.view.Reader;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CalculatorTest {

    private final PostfixCalculator calculator = new PostfixCalculator();
    private final FormConverter formulaConverter = new FormConverter();


    @DisplayName("더하기 테스트")
    @ParameterizedTest
    @CsvSource({
            "1 + 3, 4",
            "10 + 10, 20",
            "525 + 475, 1000"})
    void simplePlusTest(String formula, int answer) {
        int calculatedResult =
                calculator.getResult(
                        formulaConverter.getFormula(
                                Reader.splitWithoutSpace(formula)));

        assertEquals(answer, calculatedResult);
    }

    @DisplayName("빼기 테스트")
    @ParameterizedTest
    @CsvSource({
            "1 - 3, -2",
            "10 - 10, 0",
            "525 - 475, 50"})
    void simpleMinusTest(String formula, int answer) {
        int calculatedResult =
                calculator.getResult(
                        formulaConverter.getFormula(
                                Reader.splitWithoutSpace(formula)));

        assertEquals(answer, calculatedResult);
    }

    @DisplayName("곱하기 테스트")
    @ParameterizedTest
    @CsvSource({
            "1 * 3, 3",
            "10 * 10, 100",
            "525 * 475, 249375"})
    void simpleMutiplyTest(String formula, int answer) {
        int calculatedResult =
                calculator.getResult(
                        formulaConverter.getFormula(
                                Reader.splitWithoutSpace(formula)));

        assertEquals(answer, calculatedResult);
    }

    @DisplayName("나누기 테스트")
    @ParameterizedTest
    @CsvSource({
            "1 / 3, 0",
            "10 / 10, 1",
            "525 / 475, 1"})
    void simpleDivideTest(String formula, int answer) {
        int calculatedResult =
                calculator.getResult(
                        formulaConverter.getFormula(
                                Reader.splitWithoutSpace(formula)));

        assertEquals(answer, calculatedResult);
    }

    @Test
    @DisplayName("복잡한 연산 테스트")
    void complicatedTest() {
        String str = "1123 + 10 - 2 - 0 * (10 / 10 * 10 - 20 / 20 * 10 / 1 + (10 * 10 - 10)) + 100000 + 12000 * 10 - 120000";

        Integer result =
                calculator.getResult(formulaConverter.getFormula(Reader.splitWithoutSpace(str)));

        assertEquals(101131, result);
    }

    @Test
    @DisplayName("띄어쓰기 엉망 구별 테스트")
    void complicatedSpaceTest() {
        String str = "1                                        + (1 0 + 22 0 0 0 0 ) + 10";

        Integer result =
                calculator.getResult(formulaConverter.getFormula(Reader.splitWithoutSpace(str)));

        assertEquals(220021, result);
    }
}
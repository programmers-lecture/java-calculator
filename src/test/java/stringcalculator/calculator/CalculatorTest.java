package stringcalculator.calculator;

import stringcalculator.converter.FormConverter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import stringcalculator.view.Reader;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculatorTest {

    private final PostfixCalculator calculator = new PostfixCalculator();
    private final FormConverter formulaConverter = new FormConverter();

    @Test
    @DisplayName("더하기 테스트")
    public void simplePlusTest() {
        String str1 = "1 + 3";
        String str2 = "10 + 10";
        String str3 = "525 + 475";

        Optional<Integer> result1 =
                calculator.getResult(formulaConverter.getFormula(Reader.splitWithoutSpace(str1)));
        Optional<Integer> result2 =
                calculator.getResult(formulaConverter.getFormula(Reader.splitWithoutSpace(str2)));
        Optional<Integer> result3 =
                calculator.getResult(formulaConverter.getFormula(Reader.splitWithoutSpace(str3)));

        assertEquals(4, result1.get());
        assertEquals(20, result2.get());
        assertEquals(1000, result3.get());
    }

    @Test
    @DisplayName("빼기 테스트")
    public void simpleMinusTest() {
        String str1 = "1 - 3";
        String str2 = "10 - 10";
        String str3 = "525 - 475";

        Optional<Integer> result1 =
                calculator.getResult(formulaConverter.getFormula(Reader.splitWithoutSpace(str1)));
        Optional<Integer> result2 =
                calculator.getResult(formulaConverter.getFormula(Reader.splitWithoutSpace(str2)));
        Optional<Integer> result3 =
                calculator.getResult(formulaConverter.getFormula(Reader.splitWithoutSpace(str3)));

        assertEquals(-2, result1.get());
        assertEquals(0, result2.get());
        assertEquals(50, result3.get());
    }

    @Test
    @DisplayName("복잡한 연산 테스트")
    public void complicatedTest() {
        String str = "1123 + 10 - 2 - 0 * (10 / 10 * 10 - 20 / 20 * 10 / 1 + (10 * 10 - 10)) + 100000 + 12000 * 10 - 120000";

        Optional<Integer> result =
                calculator.getResult(formulaConverter.getFormula(Reader.splitWithoutSpace(str)));

        assertEquals(101131, result.get());
    }

    @Test
    @DisplayName("띄어쓰기 엉망 구별 테스트")
    public void complicatedSpaceTest() {
        String str = "1                                        + (1 0 + 22 0 0 0 0 ) + 10";

        Optional<Integer> result =
                calculator.getResult(formulaConverter.getFormula(Reader.splitWithoutSpace(str)));

        assertEquals(220021, result.get());
    }
}
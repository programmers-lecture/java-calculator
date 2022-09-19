package calculator;

import converter.FormulaConverter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import view.Reader;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculatorTest {

    private final Calculator calculator = new Calculator();
    private final FormulaConverter formulaConverter = new FormulaConverter();

    @Test
    @DisplayName("더하기 테스트")
    public void simplePlusTest() {
        String str1 = "1 + 3";
        String str2 = "10 + 10";
        String str3 = "525 + 475";

        Integer result1 =
                calculator.getResult(formulaConverter.getFormula(Reader.splitWithoutSpace(str1)));
        Integer result2 =
                calculator.getResult(formulaConverter.getFormula(Reader.splitWithoutSpace(str2)));
        Integer result3 =
                calculator.getResult(formulaConverter.getFormula(Reader.splitWithoutSpace(str3)));

        assertEquals(4, result1);
        assertEquals(20, result2);
        assertEquals(1000, result3);
    }

    @Test
    @DisplayName("빼기 테스트")
    public void simpleMinusTest() {
        String str1 = "1 - 3";
        String str2 = "10 - 10";
        String str3 = "525 - 475";

        Integer result1 =
                calculator.getResult(formulaConverter.getFormula(Reader.splitWithoutSpace(str1)));
        Integer result2 =
                calculator.getResult(formulaConverter.getFormula(Reader.splitWithoutSpace(str2)));
        Integer result3 =
                calculator.getResult(formulaConverter.getFormula(Reader.splitWithoutSpace(str3)));

        assertEquals(-2, result1);
        assertEquals(0, result2);
        assertEquals(50, result3);
    }

    @Test
    @DisplayName("복잡한 연산 테스트")
    public void complicatedTest() {
        String str = "1123 + 10 - 2 - 0 * (10 / 10 * 10 - 20 / 20 * 10 / 1 + (10 * 10 - 10)) + 100000 + 12000 * 10 - 120000";

        Integer result =
                calculator.getResult(formulaConverter.getFormula(Reader.splitWithoutSpace(str)));

        assertEquals(101131, result);
    }

    @Test
    @DisplayName("띄어쓰기 엉망 구별 테스트")
    public void complicatedSpaceTest() {
        String str = "1                                        + (1 0 + 22 0 0 0 0 ) + 10";

        Integer result =
                calculator.getResult(formulaConverter.getFormula(Reader.splitWithoutSpace(str)));

        assertEquals(220021, result);
    }
}
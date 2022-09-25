package stringcalculator.operator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static stringcalculator.operator.Operator.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class OperatorTest {

    @ParameterizedTest
    @ValueSource(strings = {"+", "-", "/", "*"})
    @DisplayName("연산별 연산자 검색 테스트")
    void getOperatorTest(String operator) {
        Operator findOperator = getOperator(operator);

        assertEquals(operator, findOperator.getType());
    }

    @ParameterizedTest
    @CsvSource({
            "10, +, 2, 12",
            "10, -, 2, 8",
            "10, *, 2, 20",
            "10, /, 2, 5"
    })
    @DisplayName("연산자별 연산 결과값 테스트")
    void calculateTest(int operandLeft, String operator, int operandRight, int result) {

        int calculatedResult =
                getOperator(operator)
                .calculate(operandLeft, operandRight);

        assertEquals(result, calculatedResult);
    }

}
package calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class CalculatorTest {

    private final Calculator calculator = new Calculator();

    @Test
    @DisplayName("더하기 테스트")
    public void simplePlusTest() {
        String str = "1 + 3";
        Integer result = calculator.getResult(List.of(str.split(" ")));

        System.out.println("result = " + result);

        Assertions.assertEquals(4, result);
    }
}
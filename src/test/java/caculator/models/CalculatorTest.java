package caculator.models;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class CalculatorTest {

    private final Calculator calculator = new Calculator();

    @Test
    @DisplayName("계산 테스트")
    void calculateTest() {
        List<String> postfixFormula = new ArrayList<>(Arrays.asList("5", "4", "8", "*", "2", "/", "10", "-", "+"));
        List<String> incorrectPostfixFormula1 = new ArrayList<>(Arrays.asList("5", "4", "8", "*", "2", "/", "10", "-", "+", "10"));
        List<String> incorrectPostfixFormula2 = new ArrayList<>(Arrays.asList("5", "4", "8", "*", "2", "/", "10", "-", "+", "+"));

        assertThat(calculator.calculate(postfixFormula))
                .isEqualTo(11.0);
        assertThatThrownBy(() -> calculator.calculate(incorrectPostfixFormula1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("올바르지 않은 계산식입니다.");
        assertThatThrownBy(() -> calculator.calculate(incorrectPostfixFormula2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("올바르지 않은 계산식입니다.");
    }
}

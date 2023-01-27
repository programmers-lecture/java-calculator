package application.calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class CalculatorTest {
    @DisplayName("입력된 식에 대한 결과 반환")
    @Test
    void run() {
        Calculator calculator = new Calculator();
        assertThat(calculator.run("1 + 2")).isEqualTo(3.0);
        assertThat(calculator.run("1 - 2")).isEqualTo(-1.0);
        assertThat(calculator.run("1 * 2")).isEqualTo(2.0);
        assertThat(calculator.run("1 / 2")).isEqualTo(0.5);
        assertThat(calculator.run("3 + 4 - 5 * 6 / 2")).isEqualTo(6.0);


    }
}
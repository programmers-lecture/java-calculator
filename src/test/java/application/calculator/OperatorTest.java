package application.calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class OperatorTest {
    @DisplayName("String 타입의 연산자에 해당하는 Operator 반환")
    @Test
    void findOperator() {
        assertThat(Operator.findOperator("+")).isEqualTo(Operator.ADDITION);
        assertThat(Operator.findOperator("-")).isEqualTo(Operator.SUBTRACTION);
        assertThat(Operator.findOperator("*")).isEqualTo(Operator.MULTIPLICATION);
        assertThat(Operator.findOperator("/")).isEqualTo(Operator.DIVISION);
    }
}
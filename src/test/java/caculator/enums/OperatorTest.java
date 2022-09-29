package caculator.enums;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static caculator.enums.Operator.*;

public class OperatorTest {

    @Test
    @DisplayName("연산자 찾기 테스트")
    void findOperatorTest() {
        assertThat(findOperator("+"))
                .isEqualTo(PLUS);
        assertThat(findOperator("-"))
                .isEqualTo(MINUS);
        assertThat(findOperator("*"))
                .isEqualTo(MULTIPLY);
        assertThat(findOperator("/"))
                .isEqualTo(DIVIDE);
        assertThatThrownBy(() -> findOperator("연산자아님"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("연산자를 찾을 수 없습니다.");
    }

    @Test
    @DisplayName("연산자인지 여부 판단 테스트")
    void isOperatorTest() {
        assertThat(isOperator("+"))
                .isTrue();
        assertThat(isOperator("-"))
                .isTrue();
        assertThat(isOperator("*"))
                .isTrue();
        assertThat(isOperator("/"))
                .isTrue();
        assertThat(isOperator("연산자아님"))
                .isFalse();
    }

    @Test
    @DisplayName("연산자 우선순위 판단 테스트")
    void isLowPriorityTest() {
        assertThat(PLUS.isLowPriority(MINUS))
                .isTrue();
        assertThat(PLUS.isLowPriority(DIVIDE))
                .isTrue();
        assertThat(PLUS.isLowPriority(MULTIPLY))
                .isTrue();
        assertThat(MINUS.isLowPriority(PLUS))
                .isTrue();
        assertThat(MINUS.isLowPriority(MULTIPLY))
                .isTrue();
        assertThat(MINUS.isLowPriority(DIVIDE))
                .isTrue();
        assertThat(MULTIPLY.isLowPriority(PLUS))
                .isFalse();
        assertThat(MULTIPLY.isLowPriority(MINUS))
                .isFalse();
        assertThat(MULTIPLY.isLowPriority(DIVIDE))
                .isTrue();
        assertThat(DIVIDE.isLowPriority(PLUS))
                .isFalse();
        assertThat(DIVIDE.isLowPriority(MINUS))
                .isFalse();
        assertThat(DIVIDE.isLowPriority(MULTIPLY))
                .isTrue();
    }

    @Test
    @DisplayName("연산자 계산 테스트")
    void operateTest() {
        assertThat(PLUS.operate(20.0, 4.0))
                .isEqualTo(24.0);
        assertThat(MINUS.operate(20.0, 4.0))
                .isEqualTo(16.0);
        assertThat(MULTIPLY.operate(20.0, 4.0))
                .isEqualTo(80.0);
        assertThat(DIVIDE.operate(20.0, 4.0))
                .isEqualTo(5.0);
        assertThatThrownBy(() -> DIVIDE.operate(20.0, 0.0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("0으로 나눌 수 없습니다.");
    }
}

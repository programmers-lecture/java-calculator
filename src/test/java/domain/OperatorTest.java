package domain;

import org.junit.jupiter.api.Test;

class OperatorTest {
    @Test
    void 나눗셈_예외처리() {
        Operator.DIVISION.calculate(1, 0);
    }
}
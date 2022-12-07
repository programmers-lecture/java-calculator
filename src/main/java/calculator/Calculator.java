package calculator;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public abstract class Calculator<T> {
    protected Operand<T> startOperand;
    public abstract T makeAnswer();
}
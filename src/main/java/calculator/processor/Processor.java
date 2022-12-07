package calculator.processor;

import calculator.Operand;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public abstract class Processor<T> {
    protected Operand<T> startOperand;
    public abstract T process();
}
package calculator.processor;

import calculator.expression.Expression;
import calculator.expression.Operand;

public interface Processor<T> {
    Operand<T> process(Expression<T> expression);
}
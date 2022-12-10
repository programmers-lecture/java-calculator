package calculator;

import calculator.expression.Expression;
import calculator.expression.Operand;
import calculator.processor.Processor;

public abstract class AbstractCalculator<T> {
    protected Processor<T> processor;
    public AbstractCalculator(Processor<T> processor){
        this.processor = processor;
    }
    public abstract Operand<T> calculate(Expression<T> expression);
}


package calculator;

import calculator.expression.Expression;
import calculator.expression.Operand;
import calculator.processor.Processor;

public class Calculator<T> extends AbstractCalculator<T>{
    public Calculator(Processor<T> processor) {
        super(processor);
    }

    @Override
    public Operand<T> calculate(Expression<T> expression) {
        return this.processor.process(expression);
    }
}

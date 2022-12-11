package calculator.expression;

import lombok.Getter;

@Getter
public class Expression<T> {
    private final Operand<T> startOperand;

    public Expression(Operand<T> operand){
        this.startOperand = operand;
    }

}

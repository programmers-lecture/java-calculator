package calculator.processor;

import calculator.expression.Expression;
import calculator.expression.Operand;
import calculator.expression.Operator;

public class SequentialProcessor<T> implements Processor<T> {
    @Override
    public Operand<T> process(Expression<T> expression) {
        boolean isOperand = true;
        Operand<T> currentOperand = expression.getStartOperand();
        Operator<T> currentOperator = null;
        while(true){
            if(isOperand){
                if(currentOperand.getLatter()==null) break;
                currentOperator = currentOperand.getLatter();
                isOperand = !isOperand;
                continue;
            }
            Operand<T> left = currentOperator.getFormer();
            Operand<T> right = currentOperator.getLatter();
            currentOperand = left.calculate(currentOperator, right);
            if(right.getLatter()!=null) right.getLatter().connectFormer(currentOperand);
            isOperand = !isOperand;
        }
        return currentOperand;
    }
}

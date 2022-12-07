package calculator.processor;

import calculator.Operand;
import calculator.Operator;

public class SequentialProcessor<T> extends Processor<T> {
    public SequentialProcessor(Operand<T> startOperand) {
        super(startOperand);
    }
    @Override
    public T process() {
        boolean isOperand = true;
        Operand<T> currentOperand = startOperand;
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
        return currentOperand.getValue();
    }
}

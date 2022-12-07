package integerCalculator;

import calculator.Calculator;
import calculator.Operand;
import calculator.Operator;

public class IntegerSequentialCalculator extends Calculator<Integer> {
    public IntegerSequentialCalculator(Operand<Integer> startOperand) {
        super(startOperand);
    }

    @Override
    public Integer makeAnswer() {
        boolean isOperand = true;
        Operand<Integer> currentOperand = startOperand;
        Operator<Integer> currentOperator = null;
        while(true){
            if(isOperand){
                if(currentOperand.getLatter()==null) break;
                currentOperator = currentOperand.getLatter();
                isOperand = !isOperand;
                continue;
            }
            Operand<Integer> left = currentOperator.getFormer();
            Operand<Integer> right = currentOperator.getLatter();
            currentOperand = left.calculate(currentOperator, right);
            if(right.getLatter()!=null) right.getLatter().connectFormer(currentOperand);
            isOperand = !isOperand;
        }
        return currentOperand.getValue();
    }
}

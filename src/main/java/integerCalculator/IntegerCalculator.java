package integerCalculator;

import calculator.Calculator;
import calculator.Operand;
import calculator.Operator;

public class IntegerCalculator extends Calculator<Integer> {
    public IntegerCalculator(Operand<Integer> startOperand) {
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
            if(!currentOperator.getSign().isPrimal()){
                currentOperand = currentOperator.getLatter();
                isOperand = !isOperand;
                continue;
            }
            Operand<Integer> left = currentOperator.getFormer();
            Operand<Integer> right = currentOperator.getLatter();
            currentOperand = left.calculate(currentOperator, right);
            if(left.getFormer()!=null) left.getFormer().connectLatter(currentOperand);
            if(right.getLatter()!=null) right.getLatter().connectFormer(currentOperand);
            isOperand = !isOperand;
        }

        currentOperand = getFirstOperand(currentOperand);
        isOperand = true;

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

    private Operand<Integer> getFirstOperand(Operand<Integer> operand){
        Operand<Integer> current = operand;
        while(current.getFormer()!=null){
            current = current.getFormer().getFormer();
        }
        return current;
    }
}

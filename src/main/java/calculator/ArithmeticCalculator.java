package calculator;

public class ArithmeticCalculator<T> extends Calculator<T> {
    public ArithmeticCalculator(Operand<T> startOperand) {
        super(startOperand);
    }
    @Override
    public T makeAnswer() {
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
            if(!currentOperator.getSign().isPrimal()){
                currentOperand = currentOperator.getLatter();
                isOperand = !isOperand;
                continue;
            }
            Operand<T> left = currentOperator.getFormer();
            Operand<T> right = currentOperator.getLatter();
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
            Operand<T> left = currentOperator.getFormer();
            Operand<T> right = currentOperator.getLatter();
            currentOperand = left.calculate(currentOperator, right);
            if(right.getLatter()!=null) right.getLatter().connectFormer(currentOperand);
            isOperand = !isOperand;
        }
        return currentOperand.getValue();
    }

    private Operand<T> getFirstOperand(Operand<T> operand){
        Operand<T> current = operand;
        while(current.getFormer()!=null){
            current = current.getFormer().getFormer();
        }
        return current;
    }
}

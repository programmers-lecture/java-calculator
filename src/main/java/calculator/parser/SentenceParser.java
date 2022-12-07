package calculator.parser;

import calculator.Operand;
import calculator.Operator;

public abstract class SentenceParser<T> {
    public Operand<T> parse(String sentence){
        String[] splitted = sentence.split(" ");
        Operand<T> firstOperand = operandFromValue(fromString(splitted[0]));
        Operand<T> lastOperand = firstOperand;
        Operator<T> lastOperator = operatorFromSign(Operator.Sign.fromSignStr(splitted[1]));
        boolean isOperand = true;
        connect(lastOperand, lastOperator);
        for(int i=2;i<splitted.length;i++){
            String s = splitted[i];
            if(isOperand){
                lastOperand = operandFromValue(fromString(s));
                connect(lastOperator, lastOperand);
                isOperand = !isOperand;
                continue;
            }
            lastOperator = new Operator<>(s);
            connect(lastOperand, lastOperator);
            isOperand = !isOperand;
        }
        return firstOperand;
    }

    protected abstract T fromString(String str);
    protected abstract Operand<T> operandFromValue(T value);
    protected abstract Operator<T> operatorFromSign(Operator.Sign sign);

    protected void connect(Operand<T> operand, Operator<T> operator){
        operand.connectLatter(operator);
        operator.connectFormer(operand);
    }

    protected void connect(Operator<T> operator, Operand<T> operand){
        operator.connectLatter(operand);
        operand.connectFormer(operator);
    }
}

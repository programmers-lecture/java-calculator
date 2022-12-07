package integerCalculator;

import calculator.Operand;
import calculator.Operator;
import calculator.SentenceParser;

public class IntegerSentenceParser implements SentenceParser<Integer> {
    @Override
    public Operand<Integer> parse(String sentence) {
        String[] splitted = sentence.split(" ");
        Operand<Integer> firstOperand = new IntegerOperand(Integer.parseInt(splitted[0]));
        Operand<Integer> lastOperand = firstOperand;
        Operator<Integer> lastOperator = new IntegerOperator(Operator.Sign.fromSignStr(splitted[1]));
        connect(lastOperand, lastOperator);
        boolean isOperand = true;
        for (int i=2;i<splitted.length;i++) {
            String s = splitted[i];
            if(isOperand){
                lastOperand = new IntegerOperand(Integer.parseInt(s));
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

    private void connect(Operand<Integer> operand, Operator<Integer> operator){
        operand.connectLatter(operator);
        operator.connectFormer(operand);
    }
    private void connect(Operator<Integer> operator, Operand<Integer> operand){
        operator.connectLatter(operand);
        operand.connectFormer(operator);
    }
}

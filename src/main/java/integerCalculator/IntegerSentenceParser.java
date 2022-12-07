package integerCalculator;

import calculator.Operand;
import calculator.Operator;
import calculator.SentenceParser;

public class IntegerSentenceParser extends SentenceParser<Integer> {
    @Override
    protected Integer fromString(String str) {
        try{
            return Integer.parseInt(str);
        }catch (NumberFormatException e){
            e.printStackTrace();
            throw new IllegalStateException();
        }
    }

    @Override
    protected Operand<Integer> operandFromValue(Integer value) {
        return new IntegerOperand(value);
    }

    @Override
    protected Operator<Integer> operatorFromSign(Operator.Sign sign) {
        return new IntegerOperator(sign);
    }
}

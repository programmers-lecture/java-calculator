package integerCalculator;

import calculator.expression.Operand;
import calculator.expression.Operator;
import calculator.parser.ExpressionParser;

public class IntegerExpressionParser extends ExpressionParser<Integer> {
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

package bigDecimalCalculator;

import calculator.Operand;
import calculator.Operator;
import calculator.parser.SentenceParser;

import java.math.BigDecimal;

public class BigDecimalSentenceParser extends SentenceParser<BigDecimal>{

    @Override
    protected BigDecimal fromString(String str) {
        try{
            return new BigDecimal(str);
        }catch (NumberFormatException e){
            throw new IllegalStateException();
        }
    }

    @Override
    protected Operand<BigDecimal> operandFromValue(BigDecimal value) {
        return new BigDecimalOperand(value);
    }

    @Override
    protected Operator<BigDecimal> operatorFromSign(Operator.Sign sign) {
        return new BigDecimalOperator(sign);
    }
}

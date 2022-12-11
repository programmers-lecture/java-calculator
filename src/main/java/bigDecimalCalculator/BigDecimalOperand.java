package bigDecimalCalculator;

import calculator.expression.Operand;
import calculator.expression.Operator;

import java.math.BigDecimal;

public class BigDecimalOperand extends Operand<BigDecimal> {
    public BigDecimalOperand(BigDecimal value) {
        super(value);
    }

    public BigDecimalOperand(BigDecimal value, Operator<BigDecimal> former, Operator<BigDecimal> latter){
        super(value, former, latter);
    }
}

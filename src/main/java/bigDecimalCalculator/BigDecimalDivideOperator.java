package bigDecimalCalculator;

import calculator.Sign;
import calculator.expression.Operand;
import calculator.expression.Operator;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BigDecimalDivideOperator extends Operator<BigDecimal> {
    public BigDecimalDivideOperator(Sign sign) {
        super(sign);
    }

    @Override
    public Operand<BigDecimal> calculate(Operand<BigDecimal> left, Operand<BigDecimal> right) {
        if(right==null) return left;
        return new BigDecimalOperand(
                left.getValue().divide(right.getValue(), RoundingMode.HALF_UP),
                left.getFormer(),
                right.getLatter());
    }
}

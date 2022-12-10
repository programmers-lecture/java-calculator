package bigDecimalCalculator;

import calculator.Sign;
import calculator.expression.Operator;

import java.math.BigDecimal;

public class BigDecimalOperator extends Operator<BigDecimal> {
    public BigDecimalOperator(Sign sign) {
        super(sign);
    }

}

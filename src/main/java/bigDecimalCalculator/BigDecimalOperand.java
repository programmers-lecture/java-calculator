package bigDecimalCalculator;

import calculator.expression.Operand;
import calculator.expression.Operator;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BigDecimalOperand extends Operand<BigDecimal> {
    public BigDecimalOperand(BigDecimal value) {
        super(value);
    }

    public BigDecimalOperand(BigDecimal value, Operator<BigDecimal> former, Operator<BigDecimal> latter){
        super(value, former, latter);
    }

    @Override
    public Operand<BigDecimal> calculate(Operator<BigDecimal> operator, Operand<BigDecimal> other) {
        if(other==null) return this;
        BigDecimal resultValue;
        switch (operator.getSign()) {
            case ADD:
                resultValue = this.value.add(other.getValue());
                return new BigDecimalOperand(resultValue, this.former, other.getLatter());
            case SUBTRACT:
                resultValue = this.value.subtract(other.getValue());
                return new BigDecimalOperand(resultValue, this.former, other.getLatter());
            case MULTIPLY:
                resultValue = this.value.multiply(other.getValue());
                return new BigDecimalOperand(resultValue, this.former, other.getLatter());
            case DIVIDE:
                resultValue = this.value.divide(other.getValue(), 3, RoundingMode.HALF_UP);
                return new BigDecimalOperand(resultValue, this.former, other.getLatter());
            default:
                throw new IllegalStateException();
        }
    }
}

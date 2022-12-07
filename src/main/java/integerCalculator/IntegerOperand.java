package integerCalculator;

import calculator.Operand;
import calculator.Operator;

public class IntegerOperand extends Operand<Integer> {
    public IntegerOperand(Integer value) {
        super(value);
    }

    public IntegerOperand(Integer value, Operator<Integer> former, Operator<Integer> latter) {
        super(value, former, latter);
    }

    @Override
    public Operand<Integer> calculate(Operator<Integer> operator, Operand<Integer> other) {
        if(other==null) return this;
        Integer resultValue;
        switch (operator.getSign()) {
            case ADD:
                resultValue = this.value+ other.getValue();
                return new IntegerOperand(resultValue, this.former, other.getLatter());
            case SUBTRACT:
                resultValue = this.value- other.getValue();
                return new IntegerOperand(resultValue, this.former, other.getLatter());
            case MULTIPLY:
                resultValue = this.value* other.getValue();
                return new IntegerOperand(resultValue, this.former, other.getLatter());
            case DIVIDE:
                resultValue = this.value/ other.getValue();
                return new IntegerOperand(resultValue, this.former, other.getLatter());
            default:
                throw new IllegalStateException();
        }
    }
}

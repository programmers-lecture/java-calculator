package calculator.expression;

import calculator.Sign;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public abstract class Operator<T> {

    private final Sign sign;
    private Operand<T> former;
    private Operand<T> latter;

    public void connectFormer(Operand<T> former){
        this.former = former;
    }

    public void connectLatter(Operand<T> latter){
        this.latter = latter;
    }

    public abstract Operand<T> calculate(Operand<T> left, Operand<T> right);
}

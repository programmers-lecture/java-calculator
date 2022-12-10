package calculator.expression;

import calculator.Sign;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Operator<T> {

    private final Sign sign;
    private Operand<T> former;
    private Operand<T> latter;

    public Operator(String signStr){
        this.sign = Sign.fromSignStr(signStr);
    }

    public void connectFormer(Operand<T> former){
        this.former = former;
    }

    public void connectLatter(Operand<T> latter){
        this.latter = latter;
    }


}

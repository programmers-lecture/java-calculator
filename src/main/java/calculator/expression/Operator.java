package calculator.expression;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Operator<T> {
    @RequiredArgsConstructor
    public enum Sign{
        ADD("+"),
        SUBTRACT("-"),
        MULTIPLY("*"),
        DIVIDE("/");

        private final String sign;

        public static Sign fromSignStr(String sign){
            for (Sign value : Sign.values()) {
                if(value.sign.equals(sign)) return value;
            }
            throw new IllegalArgumentException();
        }

        public boolean isPrimal(){
            return this==MULTIPLY || this==DIVIDE;
        }
    }

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

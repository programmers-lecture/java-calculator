package calculator.expression;

import lombok.Getter;

@Getter
public abstract class Operand<T> {
    protected T value;
    protected Operator<T> former;
    protected Operator<T> latter;

    protected Operand(T value){
        this.value = value;
    }

    public Operand(T value, Operator<T> former, Operator<T> latter){
        this(value);
        this.former = former;
        this.latter = latter;
    }

    public abstract Operand<T> calculate(Operator<T> operator, Operand<T> other);

    public void connectFormer(Operator<T> former){
        this.former = former;
    }

    public void connectLatter(Operator<T> latter){
        this.latter = latter;
    }
}

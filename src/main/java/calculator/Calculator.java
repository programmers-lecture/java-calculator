package calculator;

public abstract class Calculator<T> {
    protected enum Type{
        SEQUENTIAL, ARITHMETIC
    }

    protected Type type;

    public Calculator<T> asSequential(){
        type = Type.SEQUENTIAL;
        return this;
    }

    public Calculator<T> asArithmetic(){
        type = Type.ARITHMETIC;
        return this;
    }

    public abstract void calculate(String input);
}

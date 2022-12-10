package calculator;

public abstract class Calculator {

    protected CalculatorType type;

    public Calculator(CalculatorType type){
        this.type = type;
    }

    public abstract void calculate(String input);
}

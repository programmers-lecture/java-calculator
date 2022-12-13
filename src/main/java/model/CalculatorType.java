package model;
import java.util.Arrays;
import java.util.Optional;
import java.util.function.BiFunction;

public enum CalculatorType{
    ADD("+",(left,right) -> left + right),
    SUBTRACT("-",(left,right) -> left - right),
    MULTIPLY("*", (left,right) -> left * right),
    DIVIDE("/", (left,right) ->
                {if (right == 0){throw new ArithmeticException("0은 안됩니다.");}
                return left / right;});

    private String operator;
    private final BiFunction<Double, Double, Double> process;

    public String getOperator() {
        return operator;
    }

    CalculatorType(String operator, BiFunction<Double,Double,Double> process) {
        this.operator = operator;
        this.process = process;
    }

    public double calculate(double oldResult, double currentValue){
        return process.apply(oldResult, currentValue);
    }
}


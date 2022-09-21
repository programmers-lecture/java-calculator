package calculator.domain;

import java.util.Arrays;
import java.util.Optional;
import java.util.function.BiFunction;

public enum Operator {
    PLUS("+",1, (operand1,operand2) -> operand1+operand2),
    MINUS("-",1, (operand1,operand2) -> operand1-operand2),
    MUL("*",2, (operand1,operand2) -> operand1*operand2),
    DIV("/",2, (operand1,operand2) -> {
      if(operand2 == 0){
        throw new IllegalArgumentException("0으로 나눌수 없습니다");
      }
      return operand1/operand2;
  });

    private final String symbol;
    private final int priority;

    private final BiFunction<Double, Double, Double> operation;

    Operator(String symbol, int priority, BiFunction<Double, Double, Double> operation){
        this.symbol = symbol;
        this.priority = priority;
        this.operation = operation;
    }

    public String getSymbol() {
        return symbol;
    }

    public int getPriority() {
      return priority;
    }


    public double operate(double operand1, double operand2){
      return operation.apply(operand1, operand2);
    }


}

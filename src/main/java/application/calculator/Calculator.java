package application.calculator;

import java.util.List;

public class Calculator {
    private static final String SPACE = " ";
    private static final int FIRST = 0;
    Expression expression;

    private void setExpression(Expression expression) {
        this.expression = expression;
    }

    public double run(String input) {
        setExpression(new Expression(input.split(SPACE)));
        List<Double> numbers = expression.getNumbers();
        List<Operator> operators = expression.getOperators();
        return calculate(numbers, operators);
    }

    private double calculate(List<Double> numbers, List<Operator> operators) {
        double num1 = numbers.remove(FIRST);
        for(Operator operator : operators) {
            double num2 = numbers.remove(FIRST);
            num1 = operator.getCalculation().apply(num1, num2);
        }
        return num1;
    }
}



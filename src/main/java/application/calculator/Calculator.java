package application.calculator;

import java.util.List;

public class Calculator {
    Expression expression;

    private void setExpression(Expression expression) {
        this.expression = expression;
    }

    private double calculate (List<Double> numbers, List<Operator> operators) {
        double num1 = numbers.remove(0);
        for(Operator operator : operators) {
            double num2 = numbers.remove(0);
            num1 = operator.getCalculation().apply(num1, num2);
        }
        return num1;
    }

    public double run(String input) {
        setExpression(new Expression(input.split(" ")));
        List<Double> numbers = expression.getNumbers();
        List<Operator> operators = expression.getOperators();
        return calculate(numbers, operators);
    }
}



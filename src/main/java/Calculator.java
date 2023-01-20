import java.util.List;
import java.util.Scanner;

public class Calculator {
    Addition addition;
    Subtraction subtraction;
    Multiplication multiplication;
    Division division;
    Expression expression;

    public Calculator (Addition addition, Subtraction subtraction, Multiplication multiplication, Division division) {
        this.addition = addition;
        this.subtraction = subtraction;
        this.multiplication = multiplication;
        this.division = division;
    }
    private void setExpression(Expression expression) {
        this.expression = expression;
    }

    private double calculate (List<Double> numbers, List<String> operators) {
        double num1 = numbers.remove(0);
        for(String operator : operators) {
            double num2 = numbers.remove(0);
            num1 = getCalculation(operator).calculate(num1, num2);
        }
        return num1;
    }

    private Calculation getCalculation(String operator) {
        if (operator.equals("+")) {
            return addition;
        }
        if (operator.equals("-")) {
            return subtraction;
        }
        if (operator.equals("*")) {
            return multiplication;
        }
        if (operator.equals("/")) {
            return division;
        }
        throw new IllegalArgumentException("Illegal Argument Exception\n" + "Illegal Argument : " + operator);
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        Calculator calculator = new Calculator(new Addition(), new Subtraction(), new Multiplication(), new Division());
        while (true) {
            String input = kb.nextLine();
            calculator.setExpression(new Expression(input.split(" ")));
            List<Double> numbers = calculator.expression.getNumbers();
            List<String> operators = calculator.expression.getOperators();
            double result = calculator.calculate(numbers, operators);
            System.out.println("결과 : " + result + "\n");
        }
    }
}



import java.util.Stack;

public class Calculator {
    public Calculator() {

    }
    private static Operator operator;
    private static Postfix postfix;
    public Double calculate(String input) {
        postfix = new Postfix();
        operator = new Operator();

        String[] arr = input.split(" ");

        String postfixStr = postfix.converter(arr);
        return postCalculator(postfixStr);
    }

    public Double postCalculator(String str) {
        Stack<Double> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            Character c = str.charAt(i);
            if (!operator.isOperator(c)) {
                stack.push(Double.parseDouble(String.valueOf(c)));
            } else {
                Double second = stack.pop();
                Double first = stack.pop();
                stack.push(operator.operate(first, second, c));
            }
        }

        return stack.pop();
    }
}

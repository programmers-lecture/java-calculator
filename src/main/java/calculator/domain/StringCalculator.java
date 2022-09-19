package calculator.domain;


import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.stream.Collectors;

public class StringCalculator {

    private static Deque<String> stack = new ArrayDeque<>();
    public double calculate(String[] elements){
        PostfixConvertor postfixConvertor = new PostfixConvertor();
        String[] postfixValue = postfixConvertor.convertFormula(elements);
        for(String value : postfixValue){
            if(Character.isDigit(value.charAt(0))){
                stack.push(value);
                continue;
            }
            operateAndPush(value);

        }
        return Double.parseDouble(stack.pop());
    }

    public void operateAndPush(String op){
        double operand1 = Double.parseDouble(stack.pop());
        double operand2 = Double.parseDouble(stack.pop());
        stack.push(Double.toString(operate(operand1,operand2,op)));
    }

    public double operate(double operand1, double operand2, String op){
        Operator operator = Operator.findOperator(op);
        return operator.apply(operand1, operand2);
    }


}

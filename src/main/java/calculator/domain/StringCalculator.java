package calculator.domain;


import java.util.ArrayDeque;
import java.util.Deque;

public class StringCalculator {

    PostfixConvertor postfixConvertor;
    OperatorService operatorService;
    private static final Deque<String> stack = new ArrayDeque<>();
    public StringCalculator(){
        postfixConvertor = new PostfixConvertor();
        operatorService = new OperatorService();
    }
    public double calculate(String[] elements){
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


    public void operateAndPush(String symbol){
        double operand2 = Double.parseDouble(stack.pop());
        double operand1 = Double.parseDouble(stack.pop());
        Operator operator = operatorService.findOperator(symbol);
        stack.push(Double.toString(operator.operate(operand1,operand2)));
    }



}

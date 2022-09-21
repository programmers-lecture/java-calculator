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
            stackPushFormula(value);
        }
        return Double.parseDouble(stack.pop());
    }


    public void stackPushFormula(String value){
        if(Character.isDigit(value.charAt(0))){
            stack.push(value);
            return;
        }
        operateAndPush(value);
    }

    public void operateAndPush(String symbol){
        double operand2 = Double.parseDouble(stack.pop());
        double operand1 = Double.parseDouble(stack.pop());
        Operator operator = operatorService.findOperator(symbol);
        double operateValue = operator.operate(operand1,operand2);
        stack.push(Double.toString(operateValue));
    }



}

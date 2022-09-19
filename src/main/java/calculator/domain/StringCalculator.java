package calculator.domain;


import java.util.Arrays;
import java.util.stream.Collectors;

public class StringCalculator {

    public double calculate(String[] elements){
        PostfixConvertor postfixConvertor = new PostfixConvertor();
        String[] strings = postfixConvertor.convertFormula(elements);
        for(String s : strings){
            System.out.println(s);
        }
        double result = Double.parseDouble(elements[0]);
        for(int i=1; i<elements.length; i+=2){
            String op = elements[i];
            result = operate(result, Double.parseDouble(elements[i+1]),op);
        }
        return result;
    }

    public double operate(double operand1, double operand2, String op){
        Operator operator = Operator.findOperator(op);
        return operator.apply(operand1, operand2);
    }


}

package calculator.domain;

import java.util.ArrayList;
import java.util.List;

public class StringCalculator {

    public double calculate(String[] elements){
        double result = Double.parseDouble(elements[0]);
        for(int i=1; i<elements.length; i+=2){
            String op = elements[i];
            result = operate(result, Double.parseDouble(elements[i+1]),op);
        }
        return result;
    }

    public double operate(double operand1, double operand2, String op){
        Operator operator = findOperator(op);
        return operator.apply(operand1, operand2);
    }

    public Operator findOperator(String op) {

        if (Operator.PLUS.getTextOperator().equals(op)) {
            return Operator.PLUS;
        }
        if (Operator.MINUS.getTextOperator().equals(op)) {
            return Operator.MINUS;
        }
        if (Operator.MUL.getTextOperator().equals(op)) {
            return Operator.MUL;
        }
        return Operator.DIV;
    }
}

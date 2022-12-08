package controller;

import model.CalculatorType;

public class Calculator {

    public int calculate(String[] expression){

        int result = Integer.parseInt(expression[0]);
        CalculatorType calculatorType;
        
        for (int i = 2; i < expression.length; i += 2) {
            int next_num = Integer.parseInt(expression[i]);


            result = calculatorType.operate(result, next_num);
        }
        return result;
    }

}

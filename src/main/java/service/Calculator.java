package service;

import domain.Operator;
import util.CalculatorUtil;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class Calculator {

    public Integer calculatePostfix(ArrayList<String> postfix) {
        Deque<String> stack = new ArrayDeque<>();

        for (String token : postfix) {
            calculateExpression(stack, token);
        }

        return Integer.valueOf(stack.peekFirst());
    }

    private void calculateExpression(Deque<String> stack, String token) {
        if (CalculatorUtil.isNumeric(token)) {
            stack.addFirst(token);
            return;
        }

        Integer secondOperand = Integer.valueOf(stack.pollFirst());
        Integer firstOperand = Integer.valueOf(stack.pollFirst());
        Integer calculationResult = Operator.findOperatorBySymbol(token).calculate(firstOperand, secondOperand);
        stack.addFirst(String.valueOf(calculationResult));
    }
}
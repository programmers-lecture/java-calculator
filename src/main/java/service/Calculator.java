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
            if (CalculatorUtil.isNumeric(token)) {
                stack.addFirst(token);
            } else {
                Integer right = Integer.valueOf(stack.pollFirst());
                Integer left = Integer.valueOf(stack.pollFirst());
                Integer calculationResult = Operator.findOperatorBySymbol(token).calculate(left, right);
                stack.addFirst(String.valueOf(calculationResult));
            }
        }

        return Integer.valueOf(stack.peekFirst());
    }
}
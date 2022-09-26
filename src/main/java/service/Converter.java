package service;

import util.CalculatorUtil;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;


public class Converter {
    private final Priority priority = new Priority();

    public ArrayList<String> convertToPostfix(String expression) {
        String[] infix = expression.split(" ");
        ArrayList<String> postfix = new ArrayList<>();
        Deque<String> stack = new ArrayDeque<>();

        for (String token : infix) {
            formPostfixByToken(postfix, stack, token);
        }

        while (!stack.isEmpty()) {
            postfix.add(stack.pollFirst());
        }

        return postfix;
    }

    private void formPostfixByToken(ArrayList<String> postfix, Deque<String> stack, String token) {
        if (CalculatorUtil.isNumeric(token)) {
            postfix.add(token);
            return;
        }

        while (!stack.isEmpty() && priority.isPriorOrEqual(stack.peekFirst(), token)) {
            postfix.add(stack.pollFirst());
        }
        stack.addFirst(token);
    }
}

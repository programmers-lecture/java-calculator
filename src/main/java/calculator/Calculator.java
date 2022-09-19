package calculator;

import converter.PostfixConverter;
import operator.Operator;

import java.util.List;
import java.util.Optional;
import java.util.Stack;

public class Calculator {

    private final PostfixConverter postfixConverter;

    public Calculator() {
        this.postfixConverter = new PostfixConverter();
    }

    public Integer getResult(List<String> list) {
        List<String> format = postfixConverter.getFormat(list);
        Stack<String> stack = new Stack<>();

        for (String value : format) {
            handleDigit(stack, value);
            handleOperator(stack, value);
        }

        return Integer.parseInt(stack.pop());
    }

    private void handleOperator(Stack<String> stack, String value) {
        if (checkOperator(value)) {
            int b = Integer.parseInt(stack.pop());
            int a = Integer.parseInt(stack.pop());
            stack.push(String.valueOf(Operator.calculate(a, value, b)));
        }
    }

    private void handleDigit(Stack<String> stack, String value) {
        if (checkDigit(value)) stack.push(value);
    }

    private boolean checkDigit(String value) {
        return Character.isDigit(Optional.ofNullable(value).orElseThrow().charAt(0));
    }

    private boolean checkOperator(String value) {
        return Operator.checkOperator(value);
    }


}

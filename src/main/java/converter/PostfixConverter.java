package converter;

import operator.Operator;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import static operator.Operator.*;

public class PostfixConverter {

    public List<String> getFormat(List<String> list) {
        Stack<String> operatorStack = new Stack<>();
        List<String> format = new ArrayList<>();

        for (String value : list) {
            pushOperator(operatorStack, format, value);
            addDigit(format, value);
            pushLeftBracket(operatorStack, value);
            handleRightBracket(operatorStack, format, value);
        }
        addLeftStack(operatorStack, format);

        return format;
    }

    private void pushLeftBracket(Stack<String> operatorStack, String value) {
        if (checkLeftBracket(value)) operatorStack.push(value);
    }

    private void handleRightBracket(Stack<String> operatorStack, List<String> format, String value) {
        if (!checkRightBracket(value)) return;
        while (!operatorStack.isEmpty() && getOperator(operatorStack.peek()) != LEFT_BRACKET) {
            format.add(operatorStack.pop());
        }
        if(!operatorStack.isEmpty()) operatorStack.pop();

    }

    private void pushOperator(Stack<String> operatorStack, List<String> format, String value) {
        if (!checkOperator(value)) return;
        while (!operatorStack.isEmpty() && checkPriorityBigger(operatorStack, value)) {
            format.add(operatorStack.pop());
        }
        operatorStack.add(value);
    }

    private void addDigit(List<String> format, String value) {
        if (checkOperator(value)) return;
        if (checkBracket(value)) return;
        format.add(value);
    }

    private void addLeftStack(Stack<String> operatorStack, List<String> format) {
        while (!operatorStack.isEmpty()) {
            format.add(operatorStack.pop());
        }
    }

    private boolean checkLeftBracket(String value) {
        if (checkDigit(value)) return false;
        return Operator.checkLeftBracket(getOperator(value));
    }

    private boolean checkRightBracket(String value) {
        if (checkDigit(value)) return false;
        return Operator.checkRightBracket(getOperator(value));
    }

    private boolean checkBracket(String value) {
        if (checkDigit(value)) return false;
        return checkLeftBracket(value) || checkRightBracket(value);
    }

    private boolean checkOperator(String value) {
        return !checkBracket(value) && !checkDigit(value);
    }

    private boolean checkPriorityBigger(Stack<String> operatorStack, String value) {
        if (checkDigit(value)) return false;
        if (operatorStack.isEmpty()) return false;
        return getOperator(operatorStack.peek()).getPriority() >= getOperator(value).getPriority();
    }
}

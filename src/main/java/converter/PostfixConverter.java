package converter;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import static operator.Operator.*;

public class PostfixConverter {

    public List<String> getPostfixFormat(List<String> list) {
        Stack<String> operStack = new Stack<>();
        List<String> postfixFormat = new ArrayList<>();

        for (String value : list) {
            addPostfixDigit(postfixFormat, value);
            addPostfixOperator(operStack, postfixFormat, value);
            pushLeftBracket(postfixFormat, value);
            addPostfixUntilBracketEnd(operStack, postfixFormat, value);
            pushWhenStackEmpty(operStack, value);
        }
        addPostfixLeft(operStack, postfixFormat);

        return postfixFormat;
    }

    private void addPostfixLeft(Stack<String> operStack, List<String> postfixFormat) {
        while (!operStack.isEmpty()) {
            postfixFormat.add(operStack.pop());
        }
    }

    private void addPostfixDigit(List<String> postfixFormat, String value) {
        if (checkDigit(value)) {
            postfixFormat.add(value);
        }
    }

    private void addPostfixOperator(Stack<String> operStack, List<String> postfixFormat, String value) {
        if (!checkDigit(value) && checkStackNotEmpty(operStack) && checkNotBracket(getOperator(value))) {
            while (checkStackNotEmpty(operStack) && !checkCurrPriorityIsSmallerThanInStack(operStack, value)) {
                postfixFormat.add(operStack.pop());
            }
        }
    }

    private void pushLeftBracket(List<String> postfixFormat, String value) {
        if (!checkDigit(value) && checkLeftBracket(getOperator(value))) {
            postfixFormat.add(value);
        }
    }

    private void addPostfixUntilBracketEnd(Stack<String> operStack, List<String> postfixFormat, String value) {
        if (!checkDigit(value) && checkStackNotEmpty(operStack) && checkRightBracket(getOperator(value))) {
            while (checkStackNotEmpty(operStack) && checkNotLeftBracket(operStack)) {
                postfixFormat.add(operStack.pop());
            }
            if (checkStackNotEmpty(operStack)) operStack.pop();
        }
    }

    private void pushWhenStackEmpty(Stack<String> operStack, String value) {
        if (!checkDigit(value) && !checkStackNotEmpty(operStack)) {
            operStack.push(value);
        }
    }

    private boolean checkNotLeftBracket(Stack<String> operStack) {
        return !operStack.peek().equals(LEFT_BRACKET.getType());
    }

    private boolean checkCurrPriorityIsSmallerThanInStack(Stack<String> operStack, String value) {
        return getOperator(operStack.peek()).getPriority() > getOperator(value).getPriority();
    }

    private boolean checkStackNotEmpty(Stack<String> operStack) {
        return !operStack.isEmpty();
    }

    private boolean checkDigit(String value) {
        return Character.isDigit(value.charAt(0));
    }
}

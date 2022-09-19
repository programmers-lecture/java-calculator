package calculator;

import operator.OperatorRepository;

import java.util.List;
import java.util.Stack;

import static operator.Operator.*;

public class Calculator {

    private OperatorRepository operatorRepository;

    public Calculator(OperatorRepository operatorRepository) {
        this.operatorRepository = operatorRepository;
    }

    public Integer getResult(List<String> strings) {
        Stack<String> stack = operatorRepository.getStack(strings);
        Stack<String> calStack = new Stack<>();

        while (!stack.isEmpty()) {
            if (!calStack.isEmpty()) {
                String stackPeek = stack.peek();
                String calStackPeek = calStack.peek();

                checkCalculateAvailable(stack, calStack, stackPeek, calStackPeek);
                checkBracketLeftRightRemovable(stack, calStack, stackPeek, calStackPeek);
                waitForNextString(stack, calStack);
            }

            if (calStack.isEmpty()) calStack.push(stack.pop());
        }

        return Integer.valueOf(calStack.pop());
    }

    private void waitForNextString(Stack<String> stack, Stack<String> calStack) {
        calStack.push(stack.pop());
    }

    private void checkCalculateAvailable(Stack<String> stack, Stack<String> calStack, String stackPeek, String calStackPeek) {
        if (checkOperator(calStackPeek) && checkDigit(stackPeek)) {
            String operator = calStack.pop();
            int a = Integer.parseInt(calStack.pop());
            int b = Integer.parseInt(stack.pop());

            calStack.push(String.valueOf(calculate(a, operator, b)));
        }
    }

    private void checkBracketLeftRightRemovable(Stack<String> stack, Stack<String> calStack, String stackPeek, String calStackPeek) {
        if (checkLeftBracket(calStackPeek) && checkRightBracket(stackPeek)) {
            calStack.pop();
            stack.pop();
        }
    }

    private boolean checkDigit(String value) {
        return Character.isDigit(value.charAt(0));
    }

    private boolean checkLeftBracket(String value) {
        return value.equals("(");
    }

    private boolean checkRightBracket(String value) {
        return value.equals(")");
    }

}

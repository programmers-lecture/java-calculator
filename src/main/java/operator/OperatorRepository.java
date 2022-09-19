package operator;

import java.util.*;

import static operator.Operator.checkOperator;

public class OperatorRepository {

    public OperatorRepository() {
    }

    public Stack<String> getStack(List<String> strings) {
        return separateString(strings);
    }

    private Stack<String> separateString(List<String> strings) {
        Stack<String> stack = new Stack<>();
        StringBuilder numberBuilder = new StringBuilder();

        for (String value : strings) {
            checkDigitThenSaveAtNumberBuilderTemporary(numberBuilder, value);
            checkNumberBuilderCanBePushed(stack, numberBuilder, value);
            checkOperatorThenPush(stack, value);
            checkBracketThenPush(stack, value);
        }
        pushLeftNumber(stack, numberBuilder);

        return stack;
    }

    private void pushLeftNumber(Stack<String> stack, StringBuilder numberBuilder) {
        if (checkLeftNumberBuilder(numberBuilder)) {
            stack.push(numberBuilder.toString());
        }
    }

    private void checkBracketThenPush(Stack<String> stack, String o) {
        if (checkBracket(o)) stack.push(o);
    }

    private void checkOperatorThenPush(Stack<String> stack, String o) {
        if (checkOperator(o)) stack.push(o);
    }

    private void checkDigitThenSaveAtNumberBuilderTemporary(StringBuilder numberBuilder, String o) {
        if (checkDigit(o)) numberBuilder.append(o);
    }

    private void checkNumberBuilderCanBePushed(Stack<String> stack, StringBuilder numberBuilder, String o) {
        if (checkLeftNumberBuilder(numberBuilder) && !checkDigit(o)) {
            stack.push(numberBuilder.toString());
            numberBuilder.delete(0, numberBuilder.length());
        }
    }

    private boolean checkLeftNumberBuilder(StringBuilder numberBuilder) {
        return numberBuilder.length() != 0;
    }

    private boolean checkBracket(String o) {
        return o.equals("(") || o.equals(")");
    }

    private boolean checkDigit(String str) {
        return Character.isDigit(str.charAt(0));
    }

}

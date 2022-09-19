package converter;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import static operator.Operator.checkOperator;

public class FormulaConverter {

    public List<String> getFormula(List<String> strings) {
        return separateString(strings);
    }

    private List<String> separateString(List<String> strings) {
        List<String> stack = new ArrayList<>();
        StringBuilder numberBuilder = new StringBuilder();

        for (String value : strings) {
            checkDigitThenSaveAtNumberBuilderTemporary(numberBuilder, value);
            checkNumberBuilderCanBePushed(stack, numberBuilder, value);
            checkOperatorThenPush(stack, value);
            checkBracketThenPush(stack, value);
        }
        addLeftNumber(stack, numberBuilder);

        return stack;
    }

    private void addLeftNumber(List<String> stack, StringBuilder numberBuilder) {
        if (checkLeftNumberBuilder(numberBuilder)) {
            stack.add(numberBuilder.toString());
        }
    }

    private void checkBracketThenPush(List<String> stack, String o) {
        if (checkBracket(o)) stack.add(o);
    }

    private void checkOperatorThenPush(List<String> stack, String o) {
        if (checkOperator(o)) stack.add(o);
    }

    private void checkDigitThenSaveAtNumberBuilderTemporary(StringBuilder numberBuilder, String o) {
        if (checkDigit(o)) numberBuilder.append(o);
    }

    private void checkNumberBuilderCanBePushed(List<String> stack, StringBuilder numberBuilder, String o) {
        if (checkLeftNumberBuilder(numberBuilder) && !checkDigit(o)) {
            stack.add(numberBuilder.toString());
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

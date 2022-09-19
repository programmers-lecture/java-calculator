package converter;

import java.util.ArrayList;
import java.util.List;

import static operator.Operator.checkOperator;

public class FormulaConverter {

    public List<String> getFormula(List<String> strings) {
        return separateString(strings);
    }

    private List<String> separateString(List<String> strings) {
        List<String> list = new ArrayList<>();
        StringBuilder numberBuilder = new StringBuilder();

        for (String value : strings) {
            checkDigitThenSaveAtNumberBuilderTemporary(numberBuilder, value);
            checkNumberBuilderCanBePushed(list, numberBuilder, value);
            checkOperatorThenPush(list, value);
            checkBracketThenPush(list, value);
        }
        addLeftNumber(list, numberBuilder);

        return list;
    }

    private void addLeftNumber(List<String> list, StringBuilder numberBuilder) {
        if (checkLeftNumberBuilder(numberBuilder)) {
            list.add(numberBuilder.toString());
        }
    }

    private void checkBracketThenPush(List<String> list, String o) {
        if (checkBracket(o)) list.add(o);
    }

    private void checkOperatorThenPush(List<String> list, String o) {
        if (checkOperator(o)) list.add(o);
    }

    private void checkDigitThenSaveAtNumberBuilderTemporary(StringBuilder numberBuilder, String o) {
        if (checkDigit(o)) numberBuilder.append(o);
    }

    private void checkNumberBuilderCanBePushed(List<String> list, StringBuilder numberBuilder, String o) {
        if (checkLeftNumberBuilder(numberBuilder) && !checkDigit(o)) {
            list.add(numberBuilder.toString());
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

package calculator.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Calculator {

    public static final String PLUS_OPERATOR = "+";
    public static final String MINUS_OPERATOR = "-";
    public static final String MULTIPLY_OPERATOR = "*";
    public static final String DIVIDE_OPERATOR = "/";

    private final List<String> formula;

    public Calculator(String[] formula) {
        this.formula = new ArrayList<>(Arrays.asList(formula));
    }

    public void hasPriority() {
        for (int i = 0; i < formula.size(); i++) {
            if (formula.get(i).equals(MULTIPLY_OPERATOR)) {
                replace(i, Operator.calculate(MULTIPLY_OPERATOR, Integer.valueOf(formula.get(i - 1)), Integer.valueOf(formula.get(i + 1))));
                i--;
            } else if (formula.get(i).equals(DIVIDE_OPERATOR)) {
                replace(i, Operator.calculate(DIVIDE_OPERATOR, Integer.valueOf(formula.get(i - 1)), Integer.valueOf(formula.get(i + 1))));
                i--;
            }
        }
    }

    public void hasNonePriority() {
        for (int i = 0; i < formula.size(); i++) {
            if (formula.get(i).equals(PLUS_OPERATOR)) {
                replace(i, Operator.calculate(PLUS_OPERATOR, Integer.valueOf(formula.get(i - 1)), Integer.valueOf(formula.get(i + 1))));
                i--;
            } else if (formula.get(i).equals(MINUS_OPERATOR)) {
                replace(i, Operator.calculate(MINUS_OPERATOR, Integer.valueOf(formula.get(i - 1)), Integer.valueOf(formula.get(i + 1))));
                i--;
            }
        }
    }

    private void replace(int index, String value) {
        for (int i = index + 1; i >= index - 1; i--) {
            formula.remove(i);
        }
        formula.add(index - 1, value);
    }


    public String getResult() {
        return formula.get(0);
    }
}

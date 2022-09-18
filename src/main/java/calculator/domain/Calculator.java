package calculator.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Calculator {

    private List<String> formula;

    private final Operator process = new Operator();

    public Calculator(String[] formula) {
        this.formula = new ArrayList<>(Arrays.asList(formula));
    }

    public void hasPriority() {
        for (int i = 0; i < formula.size(); i++) {
            if (formula.get(i).equals("*") || formula.get(i).equals("/")) {
                replace(i,
                    process.intCalculator(formula.get(i - 1), formula.get(i + 1), formula.get(i)));
                i--;
            }
        }
    }

    public void hasNonePriority() {
        for (int i = 0; i < formula.size(); i++) {
            if (formula.get(i).equals("+") || formula.get(i).equals("-")) {
                replace(i,
                    process.intCalculator(formula.get(i - 1), formula.get(i + 1), formula.get(i)));
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

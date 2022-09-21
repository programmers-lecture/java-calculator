package stringcalculator.calculator;

import stringcalculator.converter.PostfixConverter;
import stringcalculator.exception.ExceptionBody;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Optional;

import static stringcalculator.exception.ExceptionEnum.FORMULA_NULL;
import static stringcalculator.operator.Operator.*;

public class PostfixCalculator implements Calculator {

    private final PostfixConverter postfixConverter;

    public PostfixCalculator() {
        this.postfixConverter = new PostfixConverter();
    }

    public int getResult(List<String> formulaList) {
        List<String> postfixFormulas = postfixConverter.getFormula(formulaList);
        ArrayDeque<String> operandDeque = new ArrayDeque<>(formulaList.size());

        for (String formula : postfixFormulas) {
            handleDigit(operandDeque, formula);
            handleOperator(operandDeque, formula);
        }

        return Integer.parseInt(Optional
                .of(operandDeque.removeLast())
                .orElseThrow(() -> new ExceptionBody(FORMULA_NULL)));
    }

    private void handleOperator(ArrayDeque<String> operandDeque, String formula) {
        if (checkOperator(formula)) {
            int operandRight =
                    Integer.parseInt(Optional
                            .of(operandDeque.removeLast())
                            .orElseThrow(() -> new ExceptionBody(FORMULA_NULL)));
            int operandLeft =
                    Integer.parseInt(Optional
                            .of(operandDeque.removeLast())
                            .orElseThrow(() -> new ExceptionBody(FORMULA_NULL)));
            operandDeque.addLast(String.valueOf(calculate(operandLeft, formula, operandRight)));
        }
    }

    private void handleDigit(ArrayDeque<String> operandDeque, String formula) {
        if (checkDigit(formula)) operandDeque.addLast(formula);
    }

}

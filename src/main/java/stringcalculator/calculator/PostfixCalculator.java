package stringcalculator.calculator;

import stringcalculator.converter.Converter;
import stringcalculator.converter.PostfixConverter;
import stringcalculator.exception.ExceptionBody;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Optional;

import static stringcalculator.exception.ExceptionEnum.FORMULA_NULL_ERROR;
import static stringcalculator.operator.Operator.*;

public class PostfixCalculator implements Calculator {

    private final Converter converter;

    public PostfixCalculator() {
        this.converter = new PostfixConverter();
    }

    public int getResult(List<String> inputFormula) {
        List<String> postfixFormulas = converter.getFormula(formConverter.getFormula(inputFormula));
        ArrayDeque<String> operandDeque = new ArrayDeque<>(postfixFormulas.size());

        for (String formula : postfixFormulas) {
            handleDigit(operandDeque, formula);
            handleOperator(operandDeque, formula);
        }

        return Integer.parseInt(Optional
                .of(operandDeque.pollLast())
                .orElseThrow(() -> new ExceptionBody(FORMULA_NULL_ERROR)));
    }

    private void handleOperator(ArrayDeque<String> operandDeque, String formula) {
        if (checkOperator(formula)) {
            int operandRight =
                    Integer.parseInt(Optional
                            .ofNullable(operandDeque.pollLast())
                            .orElseThrow(() -> new ExceptionBody(FORMULA_NULL_ERROR)));
            int operandLeft =
                    Integer.parseInt(Optional
                            .ofNullable(operandDeque.pollLast())
                            .orElseThrow(() -> new ExceptionBody(FORMULA_NULL_ERROR)));
            operandDeque.addLast(String.valueOf(calculate(operandLeft, formula, operandRight)));
        }
    }

    private void handleDigit(ArrayDeque<String> operandDeque, String formula) {
        if (checkDigit(formula)) operandDeque.addLast(formula);
    }

}

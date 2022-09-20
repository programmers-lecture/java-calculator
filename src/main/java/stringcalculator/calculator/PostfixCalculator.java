package stringcalculator.calculator;

import stringcalculator.converter.PostfixConverter;
import stringcalculator.operator.Operator;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Optional;

public class PostfixCalculator implements Calculator {

    private final PostfixConverter postfixConverter;

    public PostfixCalculator() {
        this.postfixConverter = new PostfixConverter();
    }

    public Integer getResult(List<String> formulaList) {
        List<String> postfixFormulaList = postfixConverter.getFormula(formulaList);
        ArrayDeque<String> operandDeque = new ArrayDeque<>(formulaList.size());

        for (String formula : postfixFormulaList) {
            handleDigit(operandDeque, formula);
            handleOperator(operandDeque, formula);
        }

        return Integer.parseInt(Optional
                .of(operandDeque.removeLast())
                .orElseThrow(() -> new NullPointerException("입력하신 연산식이 잘못되어 오류가 발생하였습니다.")));
    }

    private void handleOperator(ArrayDeque<String> operandDeque, String formula) {
        if (checkOperator(formula)) {
            int operandRight =
                    Integer.parseInt(Optional
                            .of(operandDeque.removeLast())
                            .orElseThrow(() -> new NullPointerException("입력하신 연산식이 잘못되어 오류가 발생하였습니다.")));
            int operandLeft =
                    Integer.parseInt(Optional
                            .of(operandDeque.removeLast())
                            .orElseThrow(() -> new NullPointerException("입력하신 연산식이 잘못되어 오류가 발생하였습니다.")));
            operandDeque.addLast(String.valueOf(Operator.calculate(operandLeft, formula, operandRight)));
        }
    }

    private void handleDigit(ArrayDeque<String> operandDeque, String formula) {
        if (checkDigit(formula)) operandDeque.addLast(formula);
    }

    private boolean checkDigit(String formula) {
        return Character.isDigit(Optional
                .ofNullable(formula)
                .orElseThrow()
                .charAt(0)
        );
    }

    private boolean checkOperator(String formula) {
        return Operator.checkOperator(formula);
    }
}

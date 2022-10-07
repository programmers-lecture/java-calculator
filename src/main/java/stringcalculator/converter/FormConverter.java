package stringcalculator.converter;

import stringcalculator.exception.ExceptionBody;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import static stringcalculator.exception.ExceptionEnum.FORMULA_NULL_ERROR;
import static stringcalculator.operator.Operator.checkOperator;

public class FormConverter implements Converter {

    public List<String> getFormula(List<String> formulas) {
        return convertFormula(formulas);
    }

    private List<String> convertFormula(List<String> formulas) {
        List<String> operators = new ArrayList<>();
        StringBuilder operandBuilder = new StringBuilder();

        for (String formula : formulas) {
            whenWrongOperatorThenThrowException(formula);
            checkDigitThenSaveAtNumberBuilderTemporary(operandBuilder, formula);
            checkOperandBuilderCanBePushed(operators, operandBuilder, formula);
            checkOperatorThenPush(operators, formula);
            checkBracketThenPush(operators, formula);
        }
        addLeftOperand(operators, operandBuilder);

        return operators;
    }

    private void whenWrongOperatorThenThrowException(String formula) {
        if (checkInputForm(formula)) {
            new ExceptionBody(FORMULA_NULL_ERROR);
        }
    }

    private void addLeftOperand(List<String> operators, StringBuilder operandBuilder) {
        if (checkLeftNumberBuilder(operandBuilder)) {
            operators.add(operandBuilder.toString());
        }
    }

    private void checkBracketThenPush(List<String> operators, String formula) {
        if (checkBracket(formula)) operators.add(formula);
    }

    private void checkOperatorThenPush(List<String> operators, String formula) {
        if (checkOperator(formula)) operators.add(formula);
    }

    private void checkDigitThenSaveAtNumberBuilderTemporary(StringBuilder operandBuilder, String formula) {
        if (checkDigit(formula)) operandBuilder.append(formula);
    }

    private void checkOperandBuilderCanBePushed(List<String> operators, StringBuilder operandBuilder, String formula) {
        if (checkLeftNumberBuilder(operandBuilder) && !checkDigit(formula)) {
            operators.add(operandBuilder.toString());
            operandBuilder.delete(0, operandBuilder.length());
        }
    }

    private boolean checkLeftNumberBuilder(StringBuilder operandBuilder) {
        return operandBuilder.length() != 0;
    }

    private boolean checkBracket(String formula) {
        return formula.equals("(") || formula.equals(")");
    }

    private boolean checkDigit(String str) {
        return Character.isDigit(str.charAt(0));
    }

    private boolean checkInputForm(String inputForm) {
        return Pattern.compile("^[!@#$%^&_=|\\\\`~,.<>?;:'\"A-z{}\\[\\]]$")
                .matcher(inputForm)
                .find();
    }
}

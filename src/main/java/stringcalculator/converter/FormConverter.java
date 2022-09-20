package stringcalculator.converter;

import java.util.ArrayList;
import java.util.List;

import static stringcalculator.operator.Operator.checkOperator;

public class FormConverter implements Converter {

    public List<String> getFormula(List<String> formulaList) {
        return separateString(formulaList);
    }

    private List<String> separateString(List<String> formulaList) {
        List<String> operatorList = new ArrayList<>();
        StringBuilder operandBuilder = new StringBuilder();

        for (String formula : formulaList) {
            checkDigitThenSaveAtNumberBuilderTemporary(operandBuilder, formula);
            checkOperandBuilderCanBePushed(operatorList, operandBuilder, formula);
            checkOperatorThenPush(operatorList, formula);
            checkBracketThenPush(operatorList, formula);
        }
        addLeftOperand(operatorList, operandBuilder);

        return operatorList;
    }

    private void addLeftOperand(List<String> operatorList, StringBuilder operandBuilder) {
        if (checkLeftNumberBuilder(operandBuilder)) {
            operatorList.add(operandBuilder.toString());
        }
    }

    private void checkBracketThenPush(List<String> operatorList, String formula) {
        if (checkBracket(formula)) operatorList.add(formula);
    }

    private void checkOperatorThenPush(List<String> operatorList, String formula) {
        if (checkOperator(formula)) operatorList.add(formula);
    }

    private void checkDigitThenSaveAtNumberBuilderTemporary(StringBuilder operandBuilder, String formula) {
        if (checkDigit(formula)) operandBuilder.append(formula);
    }

    private void checkOperandBuilderCanBePushed(List<String> operatorList, StringBuilder operandBuilder, String formula) {
        if (checkLeftNumberBuilder(operandBuilder) && !checkDigit(formula)) {
            operatorList.add(operandBuilder.toString());
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
}

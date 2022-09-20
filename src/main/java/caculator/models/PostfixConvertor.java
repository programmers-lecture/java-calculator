package caculator.models;

import caculator.utils.Util;

import java.util.List;
import java.util.Stack;

public class PostfixConvertor {

    private List<String> postfixFormula = new Stack<>();
    private Stack<String> operands = new Stack<>();

    public List<String> convertPostfixFormula(String[] formula) {
        for (String formulaStr : formula) {
            checkIncorrectFormula(formulaStr);
            addNumberInPostfixFormula(formulaStr);
            addOperatorInPostfixFormula(formulaStr);
        }
        while (!operands.isEmpty()) {
            postfixFormula.add(operands.pop());
        }
        return postfixFormula;
    }

    private void addNumberInPostfixFormula(String formulaStr) {
        if (Util.isNumber(formulaStr))
            postfixFormula.add(formulaStr);
    }

    private void addOperatorInPostfixFormula(String formulaStr) {
        if (Util.isOperator(formulaStr)) {
            if (!operands.isEmpty()) {
                postfixFormula.add(operands.pop());
            }
            operands.push(formulaStr);
        }
    }

    private void checkIncorrectFormula(String formulaStr) {
        if (!Util.isNumber(formulaStr) && !Util.isOperator(formulaStr))
            throw new RuntimeException("올바르지 않은 계산식입니다.");
    }

}


package caculator.models;

import caculator.enums.Operator;
import caculator.utils.Util;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class PostfixConvertor {

    private List<String> postfixFormula = new ArrayList<>();
    private Deque<String> operators = new ArrayDeque<>();

    public List<String> convertPostfixFormula(String[] formula) {
        for (String formulaStr : formula) {
            checkIncorrectFormula(formulaStr);
            addNumberInPostfixFormula(formulaStr);
            addOperatorInPostfixFormula(formulaStr);
        }
        while (!operators.isEmpty()) {
            postfixFormula.add(operators.pop());
        }
        return postfixFormula;
    }

    private void addNumberInPostfixFormula(String formulaStr) {
        if (Util.isNumber(formulaStr))
            postfixFormula.add(formulaStr);
    }

    private void addOperatorInPostfixFormula(String formulaStr) {
        if (Operator.isOperator(formulaStr)) {
            if(!operators.isEmpty()) {
                Operator operator = Operator.findOperator(formulaStr);
                Operator previousOperator = Operator.findOperator(operators.peek());
                if (operator.isLowPriority(previousOperator))
                    postfixFormula.add(operators.pop());
            }
            operators.push(formulaStr);
        }
    }

    private void checkIncorrectFormula(String formulaStr) {
        if (!Util.isNumber(formulaStr) && !Operator.isOperator(formulaStr))
            throw new IllegalArgumentException("올바르지 않은 계산식입니다.");
    }

}


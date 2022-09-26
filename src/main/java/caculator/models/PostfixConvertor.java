package caculator.models;

import caculator.enums.Operator;
import caculator.utils.Util;

import java.util.*;

public class PostfixConvertor {
    public List<String> convertPostfixFormula(String[] formula) {
        List<String> postfixFormula = new ArrayList<>();
        Deque<String> operators = new ArrayDeque<>();

        for (String formulaStr : formula) {
            checkIncorrectFormula(formulaStr);
            addNumberInPostfixFormula(postfixFormula, formulaStr);
            addOperatorInOperators(postfixFormula, operators, formulaStr);
        }
        addLastOperatorsInPostfixFormula(postfixFormula, operators);
        return postfixFormula;
    }

    private void checkIncorrectFormula(String formulaStr) {
        if (!Util.isNumber(formulaStr) && !Operator.isOperator(formulaStr))
            throw new IllegalArgumentException("올바르지 않은 계산식입니다.");
    }

    private void addNumberInPostfixFormula(List<String> postfixFormula, String formulaStr) {
        if (Util.isNumber(formulaStr))
            postfixFormula.add(formulaStr);
    }

    private void addOperatorInOperators(List<String> postfixFormula, Deque<String> operators, String formulaStr) {
        if (Operator.isOperator(formulaStr)) {
            addOperatorInPostfixFormula(postfixFormula, operators, formulaStr);
            operators.push(formulaStr);
        }
    }

    private void addOperatorInPostfixFormula(List<String> postfixFormula, Deque<String> operators, String formulaStr) {
        if(operators.isEmpty())
            return;
        Operator operator = Operator.findOperator(formulaStr);
        Operator previousOperator = Operator.findOperator(operators.peek());
        if(operator.isLowPriority(previousOperator))
            postfixFormula.add(operators.pop());
    }

    private void addLastOperatorsInPostfixFormula(List<String> postfixFormula, Deque<String> operators) {
        while (!operators.isEmpty()) {
            postfixFormula.add(operators.pop());
        }
    }
}


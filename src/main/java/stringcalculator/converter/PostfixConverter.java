package stringcalculator.converter;

import stringcalculator.operator.Operator;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

import static stringcalculator.operator.Operator.*;

public class PostfixConverter implements Converter {

    public List<String> getFormula(List<String> formulas) {
        ArrayDeque<String> operatorDeque = new ArrayDeque<>(formulas.size());
        List<String> operands = new ArrayList<>();

        for (String formula : formulas) {
            pushOperator(operatorDeque, operands, formula);
            addDigit(operands, formula);
            pushLeftBracket(operatorDeque, formula);
            handleRightBracket(operatorDeque, operands, formula);
        }
        addLeftStack(operatorDeque, operands);

        return operands;
    }

    private void pushLeftBracket(ArrayDeque<String> operatorDeque, String formula) {
        if (checkLeftBracket(formula)) operatorDeque.addLast(formula);
    }

    private void handleRightBracket(ArrayDeque<String> operatorDeque, List<String> operands, String formula) {
        if (!checkRightBracket(formula)) return;
        while (!operatorDeque.isEmpty() && getOperator(operatorDeque.peekLast()) != LEFT_BRACKET) {
            operands.add(operatorDeque.removeLast());
        }
        if(!operatorDeque.isEmpty()) operatorDeque.removeLast();
    }

    private void pushOperator(ArrayDeque<String> operatorDeque, List<String> operands, String formula) {
        if (!checkOperator(formula)) return;
        while (!operatorDeque.isEmpty() && checkPriorityBigger(operatorDeque, formula)) {
            operands.add(operatorDeque.removeLast());
        }
        operatorDeque.addLast(formula);
    }

    private void addDigit(List<String> operands, String formula) {
        if (checkOperator(formula)) return;
        if (checkBracket(formula)) return;
        operands.add(formula);
    }

    private void addLeftStack(ArrayDeque<String> operatorDeque, List<String> operands) {
        while (!operatorDeque.isEmpty()) {
            operands.add(operatorDeque.removeLast());
        }
    }

    private boolean checkLeftBracket(String formula) {
        if (checkDigit(formula)) return false;
        return Operator.checkLeftBracket(getOperator(formula));
    }

    private boolean checkRightBracket(String formula) {
        if (checkDigit(formula)) return false;
        return Operator.checkRightBracket(getOperator(formula));
    }

    private boolean checkBracket(String formula) {
        if (checkDigit(formula)) return false;
        return checkLeftBracket(formula) || checkRightBracket(formula);
    }

    private boolean checkOperator(String formula) {
        return !checkBracket(formula) && !checkDigit(formula);
    }

    private boolean checkPriorityBigger(ArrayDeque<String> operatorDeque, String formula) {
        if (checkDigit(formula)) return false;
        if (operatorDeque.isEmpty()) return false;
        return getOperator(operatorDeque.peekLast()).getPriority() >= getOperator(formula).getPriority();
    }
}

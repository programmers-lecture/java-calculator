package stringcalculator.converter;

import stringcalculator.operator.Operator;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

import static stringcalculator.operator.Operator.*;

public class PostfixConverter implements Converter {

    public List<String> getFormula(List<String> formulaList) {
        ArrayDeque<String> operatorDeque = new ArrayDeque<>(formulaList.size());
        List<String> operandList = new ArrayList<>();

        for (String formula : formulaList) {
            pushOperator(operatorDeque, operandList, formula);
            addDigit(operandList, formula);
            pushLeftBracket(operatorDeque, formula);
            handleRightBracket(operatorDeque, operandList, formula);
        }
        addLeftStack(operatorDeque, operandList);

        return operandList;
    }

    private void pushLeftBracket(ArrayDeque<String> operatorDeque, String formula) {
        if (checkLeftBracket(formula)) operatorDeque.addLast(formula);
    }

    private void handleRightBracket(ArrayDeque<String> operatorDeque, List<String> operandList, String formula) {
        if (!checkRightBracket(formula)) return;
        while (!operatorDeque.isEmpty() && getOperator(operatorDeque.peekLast()) != LEFT_BRACKET) {
            operandList.add(operatorDeque.removeLast());
        }
        if(!operatorDeque.isEmpty()) operatorDeque.removeLast();
    }

    private void pushOperator(ArrayDeque<String> operatorDeque, List<String> operandList, String formula) {
        if (!checkOperator(formula)) return;
        while (!operatorDeque.isEmpty() && checkPriorityBigger(operatorDeque, formula)) {
            operandList.add(operatorDeque.removeLast());
        }
        operatorDeque.addLast(formula);
    }

    private void addDigit(List<String> operandList, String formula) {
        if (checkOperator(formula)) return;
        if (checkBracket(formula)) return;
        operandList.add(formula);
    }

    private void addLeftStack(ArrayDeque<String> operatorDeque, List<String> operandList) {
        while (!operatorDeque.isEmpty()) {
            operandList.add(operatorDeque.removeLast());
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

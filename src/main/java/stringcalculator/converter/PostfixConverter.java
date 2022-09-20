package stringcalculator.converter;

import stringcalculator.operator.Operator;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import static stringcalculator.operator.Operator.*;

public class PostfixConverter implements Converter {

    public List<String> getFormula(List<String> formulaList) {
        Stack<String> operatorStack = new Stack<>();
        List<String> operandList = new ArrayList<>();

        for (String formula : formulaList) {
            pushOperator(operatorStack, operandList, formula);
            addDigit(operandList, formula);
            pushLeftBracket(operatorStack, formula);
            handleRightBracket(operatorStack, operandList, formula);
        }
        addLeftStack(operatorStack, operandList);

        return operandList;
    }

    private void pushLeftBracket(Stack<String> operatorStack, String formula) {
        if (checkLeftBracket(formula)) operatorStack.push(formula);
    }

    private void handleRightBracket(Stack<String> operatorStack, List<String> operandList, String formula) {
        if (!checkRightBracket(formula)) return;
        while (!operatorStack.isEmpty() && getOperator(operatorStack.peek()) != LEFT_BRACKET) {
            operandList.add(operatorStack.pop());
        }
        if(!operatorStack.isEmpty()) operatorStack.pop();

    }

    private void pushOperator(Stack<String> operatorStack, List<String> operandList, String formula) {
        if (!checkOperator(formula)) return;
        while (!operatorStack.isEmpty() && checkPriorityBigger(operatorStack, formula)) {
            operandList.add(operatorStack.pop());
        }
        operatorStack.add(formula);
    }

    private void addDigit(List<String> operandList, String formula) {
        if (checkOperator(formula)) return;
        if (checkBracket(formula)) return;
        operandList.add(formula);
    }

    private void addLeftStack(Stack<String> operatorStack, List<String> operandList) {
        while (!operatorStack.isEmpty()) {
            operandList.add(operatorStack.pop());
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

    private boolean checkPriorityBigger(Stack<String> operatorStack, String formula) {
        if (checkDigit(formula)) return false;
        if (operatorStack.isEmpty()) return false;
        return getOperator(operatorStack.peek()).getPriority() >= getOperator(formula).getPriority();
    }
}

package calculator;

import converter.PostfixConverter;
import operator.Operator;

import java.util.List;
import java.util.Optional;
import java.util.Stack;

public class PostfixCalculator implements Calculator {

    final private PostfixConverter postfixConverter;

    public PostfixCalculator() {
        this.postfixConverter = new PostfixConverter();
    }

    public Optional<Integer> getResult(List<String> formulaList) {
        List<String> postfixFormulaList = postfixConverter.getFormula(formulaList);
        Stack<String> operandStack = new Stack<>();

        for (String formula : postfixFormulaList) {
            handleDigit(operandStack, formula);
            handleOperator(operandStack, formula);
        }

        return Optional.of(Integer.parseInt(operandStack.pop()));
    }

    private void handleOperator(Stack<String> operandStack, String formula) {
        if (checkOperator(formula)) {
            int operandRight = Integer.parseInt(operandStack.pop());
            int operandLeft = Integer.parseInt(operandStack.pop());
            operandStack.push(String.valueOf(Operator.calculate(operandLeft, formula, operandRight)));
        }
    }

    private void handleDigit(Stack<String> operandStack, String formula) {
        if (checkDigit(formula)) operandStack.push(formula);
    }

    private boolean checkDigit(String formula) {
        return Character.isDigit(Optional.ofNullable(formula).orElseThrow().charAt(0));
    }

    private boolean checkOperator(String formula) {
        return Operator.checkOperator(formula);
    }
    
}
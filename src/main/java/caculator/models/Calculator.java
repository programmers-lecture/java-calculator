package caculator.models;

import caculator.enums.Operator;

import java.util.List;
import java.util.Stack;

public class Calculator {

    private String[] formula;
    private List<String> postfixFormula = new Stack<>();
    private Stack<String> operands = new Stack<>();
    private Stack<Integer> numbers = new Stack<>();

    public Calculator(String[] formula) {
        this.formula = formula;
    }

    public Integer calculate() {
        convertPostfixFormula();
        for(String postfixFormulaStr: postfixFormula) {
            addNumberInNumbers(postfixFormulaStr);
            addCalculatedNumberInNumbers(postfixFormulaStr);
        }
        if(numbers.size() != 1)
            throw new RuntimeException("올바르지 않은 계산식입니다.");
        return numbers.pop();
    }

    private void addNumberInNumbers(String postfixFormulaStr) {
        if (isNumber(postfixFormulaStr))
            numbers.push(Integer.parseInt(postfixFormulaStr));
    }

    private void addCalculatedNumberInNumbers(String postfixFormulaStr) {
        if (isOperator(postfixFormulaStr)) {
            checkNumbersHasTwoNumber();
            Integer secondOperand = numbers.pop();
            Integer firstOperand = numbers.pop();
            Integer result = Operator.findOperator(postfixFormulaStr).operate(firstOperand, secondOperand);
            numbers.push(result);
        }
    }

    private void checkNumbersHasTwoNumber() {
        if(numbers.size() < 2)
            throw new RuntimeException("올바르지 않은 계산식입니다.");
    }

    private void convertPostfixFormula() {
        for(String formulaStr: formula) {
            checkIncorrectFormula(formulaStr);
            addNumberInPostfixFormula(formulaStr);
            addOperatorInPostfixFormula(formulaStr);
        }
        while(!operands.isEmpty()) {
            postfixFormula.add(operands.pop());
        }
    }

    private void addNumberInPostfixFormula(String formulaStr) {
        if(isNumber(formulaStr))
            postfixFormula.add(formulaStr);
    }

    private void addOperatorInPostfixFormula(String formulaStr) {
        if(isOperator(formulaStr)) {
            if(!operands.isEmpty()) {
                postfixFormula.add(operands.pop());
            }
            operands.push(formulaStr);
        }
    }

    private void checkIncorrectFormula(String formulaStr) {
        if(!isNumber(formulaStr) && !isOperator(formulaStr))
            throw new RuntimeException("올바르지 않은 계산식입니다.");
    }

    private boolean isOperator(String operator) {
        return operator.equals(Operator.PLUS.getOperator())
                || operator.equals(Operator.MINUS.getOperator())
                || operator.equals(Operator.MULTIPLY.getOperator())
                || operator.equals(Operator.DIVIDE.getOperator());
    }

    private boolean isNumber(String number) {
        return number.chars().allMatch(Character::isDigit);
    }
}

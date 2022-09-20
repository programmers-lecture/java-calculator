package caculator.models;

import caculator.enums.Operator;

import java.util.List;
import java.util.Stack;

public class Calculator {

    private String[] formula;

    public Calculator(String[] formula) {
        this.formula = formula;
    }

    public Integer calculate() {
        List<String> postfixFormula = convertPostfixFormula();
        System.out.println(postfixFormula);
        Stack<Integer> numbers = new Stack<>();
        for(String postfixFormulaStr: postfixFormula) {
            if (isNumber(postfixFormulaStr))
                numbers.push(Integer.parseInt(postfixFormulaStr));
            if (isOperator(postfixFormulaStr)) {
                if(numbers.size() < 2)
                    throw new RuntimeException("올바르지 않은 계산식입니다.");
                Integer secondOperand = numbers.pop();
                Integer firstOperand = numbers.pop();
                Integer result = Operator.findOperator(postfixFormulaStr).operate(firstOperand, secondOperand);
                numbers.push(result);
            }
        }
        if(numbers.size() != 1)
            throw new RuntimeException("올바르지 않은 계산식입니다.");
        return numbers.pop();
    }

    private List<String> convertPostfixFormula() {
        List<String> postfixFormula = new Stack<>();
        Stack<String> operands = new Stack<>();
        for(String formulaStr: formula) {
            if(!isNumber(formulaStr) && !isOperator(formulaStr))
                throw new RuntimeException("올바르지 않은 계산식입니다.");
            if(isNumber(formulaStr))
                postfixFormula.add(formulaStr);
            if(isOperator(formulaStr)) {
                if(!operands.isEmpty()) {
                    postfixFormula.add(operands.pop());
                }
                operands.push(formulaStr);
            }
        }
        while(!operands.isEmpty()) {
            postfixFormula.add(operands.pop());
        }
        return postfixFormula;
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

package caculator.models;

import caculator.enums.Operator;
import caculator.utils.Util;

import java.util.List;
import java.util.Stack;

public class Calculator {

    private List<String> postfixFormula;
    private Stack<Double> numbers = new Stack<>();

    public Calculator(List<String> postfixFormula) {
        this.postfixFormula = postfixFormula;
    }

    public Double calculate() {
        for(String postfixFormulaStr: postfixFormula) {
            addNumberInNumbers(postfixFormulaStr);
            addCalculatedNumberInNumbers(postfixFormulaStr);
        }
        if(numbers.size() != 1)
            throw new RuntimeException("올바르지 않은 계산식입니다.");
        return numbers.pop();
    }

    private void addNumberInNumbers(String postfixFormulaStr) {
        if (Util.isNumber(postfixFormulaStr))
            numbers.push(Double.parseDouble(postfixFormulaStr));
    }

    private void addCalculatedNumberInNumbers(String postfixFormulaStr) {
        if (Operator.isOperator(postfixFormulaStr)) {
            checkNumbersHasTwoNumber();
            Double secondOperand = numbers.pop();
            Double firstOperand = numbers.pop();
            Double result = Operator.findOperator(postfixFormulaStr).operate(firstOperand, secondOperand);
            numbers.push(result);
        }
    }

    private void checkNumbersHasTwoNumber() {
        if(numbers.size() < 2)
            throw new RuntimeException("올바르지 않은 계산식입니다.");
    }

}

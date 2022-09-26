package caculator.models;

import caculator.enums.Operator;
import caculator.utils.Util;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class Calculator {
    private static final int MIN_NUMBER_COUNT = 2;
    private static final int RESULT_NUMBER_COUNT = 1;

    private List<String> postfixFormula;
    private Deque<Double> numbers = new ArrayDeque<>();

    public Calculator(List<String> postfixFormula) {
        this.postfixFormula = postfixFormula;
    }

    public Double calculate() {
        for(String postfixFormulaStr: postfixFormula) {
            addNumberInNumbers(postfixFormulaStr);
            addCalculatedNumberInNumbers(postfixFormulaStr);
        }
        if(numbers.size() != RESULT_NUMBER_COUNT)
            throw new IllegalArgumentException("올바르지 않은 계산식입니다.");
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
        if(numbers.size() < MIN_NUMBER_COUNT)
            throw new IllegalArgumentException("올바르지 않은 계산식입니다.");
    }

}

package caculator.models;

import caculator.enums.Operator;
import caculator.utils.Util;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class Calculator {
    private static final int MIN_NUMBER_COUNT = 2;
    private static final int RESULT_NUMBER_COUNT = 1;

    public Double calculate(List<String> postfixFormula) {
        Deque<Double> numbers = new ArrayDeque<>();
        for(String postfixFormulaStr: postfixFormula) {
            addNumberInNumbers(numbers, postfixFormulaStr);
            addCalculatedNumberInNumbers(numbers, postfixFormulaStr);
        }
        checkNumbersHasResultNumberCount(numbers);
        return numbers.pop();
    }

    private void addNumberInNumbers(Deque<Double> numbers, String postfixFormulaStr) {
        if (Util.isNumber(postfixFormulaStr))
            numbers.push(Double.parseDouble(postfixFormulaStr));
    }

    private void addCalculatedNumberInNumbers(Deque<Double> numbers, String postfixFormulaStr) {
        if (Operator.isOperator(postfixFormulaStr)) {
            checkNumbersHasCalculatePossibleMinNumberCount(numbers);
            Double secondOperand = numbers.pop();
            Double firstOperand = numbers.pop();
            Double result = Operator.findOperator(postfixFormulaStr).operate(firstOperand, secondOperand);
            numbers.push(result);
        }
    }

    private void checkNumbersHasCalculatePossibleMinNumberCount(Deque<Double> numbers) {
        if(numbers.size() < MIN_NUMBER_COUNT)
            throw new IllegalArgumentException("올바르지 않은 계산식입니다.");
    }

    private void checkNumbersHasResultNumberCount(Deque<Double> numbers) {
        if(numbers.size() != RESULT_NUMBER_COUNT)
            throw new IllegalArgumentException("올바르지 않은 계산식입니다.");
    }

}

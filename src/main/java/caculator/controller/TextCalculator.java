package caculator.controller;

import caculator.enums.Operator;
import caculator.models.Calculator;
import caculator.models.PostfixConvertor;
import caculator.views.InputView;
import caculator.views.OutputView;

import java.util.List;

public class TextCalculator {

    private TextCalculator() {}

    public static void calculatorRun() {
        String[] formula = InputView.inputFormula();
        PostfixConvertor postfixConvertor = new PostfixConvertor();
        List<String> postfixFormula = postfixConvertor.convertPostfixFormula(formula);
        Calculator calculator = new Calculator();
        Double result = calculator.calculate(postfixFormula);
        OutputView.printCalculatorResult(result);
    }
}

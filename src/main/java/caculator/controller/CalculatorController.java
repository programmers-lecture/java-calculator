package caculator.controller;

import caculator.models.Calculator;
import caculator.models.PostfixConvertor;
import caculator.views.InputView;
import caculator.views.OutputView;

import java.util.List;

public class CalculatorController {
    public static void calculatorRun() {
        String[] formula = InputView.inputFormula();
        PostfixConvertor postfixConvertor = new PostfixConvertor();
        List<String> postfixFormula = postfixConvertor.convertPostfixFormula(formula);
        Calculator calculator = new Calculator(postfixFormula);
        Integer result = calculator.calculate();
        OutputView.printCalculatorResult(result);
    }
}

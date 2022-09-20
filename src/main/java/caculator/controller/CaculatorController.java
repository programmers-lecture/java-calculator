package caculator.controller;

import caculator.models.Calculator;
import caculator.views.InputView;
import caculator.views.OutputView;

public class CaculatorController {
    public static void calculatorRun() {
        String[] formula = InputView.inputFormula();
        Calculator calculator = new Calculator(formula);
        Integer result = calculator.calculate();
        OutputView.printCalculatorResult(result);
    }
}

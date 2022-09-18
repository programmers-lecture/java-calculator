package calculator.controller;

import calculator.domain.Calculator;
import calculator.view.InputView;
import calculator.view.OutputView;

public class StringCalculator {

    public void run() {
        Calculator ccc = new Calculator(InputView.inputFormula());
        ccc.hasPriority();
        ccc.hasNonePriority();
        OutputView.showResult(ccc.getResult());
    }
}

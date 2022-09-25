package calculator.controller;

import calculator.domain.Calculator;
import calculator.view.InputView;
import calculator.view.InputViewImpl;
import calculator.view.OutputView;

public class StringCalculator {

    public void run() {
        InputView inputView = new InputViewImpl();
        Calculator calculator = new Calculator(inputView.inputFormula());
        calculator.hasPriority();
        calculator.hasNonePriority();
        OutputView.showResult(calculator.getResult());
    }
}

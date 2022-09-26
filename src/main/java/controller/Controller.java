package controller;

import service.Calculator;
import service.Converter;
import view.InputView;
import view.OutputView;

import java.util.ArrayList;

public class Controller {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final Converter converter = new Converter();
    private final Calculator calculator = new Calculator();

    public void run() {
        String expression = inputView.getFirstExpression();

        while (expression != null) { // TODO: 실행 상태를 나타내는 변수로 변경
            ArrayList<String> postfix = converter.convertToPostfix(expression);
            Integer calculationResult = calculator.calculatePostfix(postfix);
            outputView.printCalculationResult(calculationResult);

            expression = inputView.getNewExpression();
        }

        outputView.printExitMessage();
    }
}

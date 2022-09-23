package controller;

import service.Calculator;
import service.Converter;
import util.Reader;
import view.InputView;
import view.OutputView;

import java.util.ArrayList;

public class Controller {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final Converter converter = new Converter();
    private final Calculator calculator = new Calculator();

    public void run() {
        String expression = readFirstExpression();

        while (!isExitOrder(expression)) { // TODO: 실행 상태를 나타내는 변수로 변경
            ArrayList<String> postfix = converter.convertToPostfix(expression);
            Integer calculationResult = calculator.calculatePostfix(postfix);
            outputView.printCalculationResult(calculationResult);

            inputView.printGuideMessage();
            expression = Reader.read();
        }

        outputView.printExitMessage();
    }

    private String readFirstExpression() {
        inputView.printWelcomeMessage();
        inputView.printGuideMessage();
        return Reader.read();
    }

    private boolean isExitOrder(String order) {
        return order.equals("0");
    }
}

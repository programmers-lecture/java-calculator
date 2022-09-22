package controller;

import util.Reader;
import view.InputView;
import view.OutputView;

public class Controller {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void run() {
        String expression = readFirstExpression();

        while (!isExitOrder(expression)) {
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

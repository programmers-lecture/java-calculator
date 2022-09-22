package controller;

import util.Reader;
import view.InputView;
import view.OutputView;

public class Controller {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void run() {
        String expression = Reader.read();

        while (!isExitOrder(expression)) {
            System.out.println("test");
        }

        outputView.
    }

    private boolean isExitOrder(String order) {
        return order.equals("0");
    }
}

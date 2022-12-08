package controller;

import view.InputView;
import view.OutputView;

public class CalculatorController {

    public void main(){
        String content = new InputView().input();
        String[] expression = content.split(" ");

        Calculator calculator = new Calculator();
        int result = calculator.calculate(expression);

        new OutputView().output(result);
    }

}

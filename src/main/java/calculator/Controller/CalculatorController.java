package calculator.Controller;

import calculator.domain.StringCalculator;

public class CalculatorController {
    public void run(){
        ViewController viewController = new ViewController();
        StringCalculator stringCalculator = new StringCalculator();
        String[] expression = viewController.inputView();
        double result = stringCalculator.calculate(expression);
        viewController.outputView(result);
    }
}

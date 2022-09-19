package calculator;

import calculator.domain.StringCalculator;
import calculator.view.InputView;

public class Application {
    public static void main(String[] args) {
        //TODO: 계산기 구현
        InputView inputView = new InputView();
        StringCalculator stringCalculator = new StringCalculator();

        String[] input = inputView.inputFormula();
        double ans = stringCalculator.calculate(input);
        System.out.print(ans);
    }
}

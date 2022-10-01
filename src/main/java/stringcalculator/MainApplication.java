package stringcalculator;

import stringcalculator.calculator.PostfixCalculator;
import stringcalculator.converter.PostfixConverter;
import stringcalculator.view.Sender;

public class MainApplication {

    public static void main(String[] args) {
        int result = new PostfixCalculator().getResult();
        Sender.sendCalResultMessage(String.valueOf(result));
    }
}

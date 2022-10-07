package stringcalculator;

import stringcalculator.calculator.PostfixCalculator;
import stringcalculator.view.Sender;

import static stringcalculator.view.Reader.read;

public class MainApplication {

    public static void main(String[] args) {
        int result = new PostfixCalculator().getResult(read());
        Sender.sendCalResultMessage(String.valueOf(result));
    }
}

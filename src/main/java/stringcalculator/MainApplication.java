package stringcalculator;

import stringcalculator.calculator.PostfixCalculator;
import stringcalculator.converter.PostfixConverter;
import stringcalculator.view.Reader;
import stringcalculator.view.Sender;

import static stringcalculator.view.Reader.*;

public class MainApplication {

    public static void main(String[] args) {
        int result = new PostfixCalculator().getResult(read());
        Sender.sendCalResultMessage(String.valueOf(result));
    }
}

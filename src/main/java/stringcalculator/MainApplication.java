package stringcalculator;

import stringcalculator.calculator.PostfixCalculator;
import stringcalculator.converter.FormConverter;
import stringcalculator.view.Sender;

import java.util.List;
import java.util.Optional;

import static stringcalculator.view.Reader.read;

public class MainApplication {

    public static void main(String[] args) {
        List<String> formulas = new FormConverter().getFormula(read());
        Integer result = new PostfixCalculator().getResult(formulas);
        Sender.sendCalResultMessage(result.toString());
    }
}

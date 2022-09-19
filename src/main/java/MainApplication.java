import calculator.Calculator;
import converter.FormulaConverter;
import view.Sender;

import java.util.List;

import static view.Reader.read;

public class MainApplication {

    public static void main(String[] args) {
        List<String> formula = new FormulaConverter().getFormula(read());
        Integer result = new Calculator().getResult(formula);
        Sender.sendCalResultMessage(result.toString());
    }
}

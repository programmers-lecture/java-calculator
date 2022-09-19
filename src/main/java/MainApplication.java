import calculator.Calculator;
import converter.FormulaConverter;
import view.Reader;
import view.Sender;

import java.util.List;
// 12412 - 1348 + 134 * 10 - (10 / 10 * 20 + 10 - 4) + 10 - 20 / 2
public class MainApplication {

    public static void main(String[] args) {
        List<String> formula = new FormulaConverter().getFormula(Reader.read());
        Integer result = new Calculator().getResult(formula);
        Sender.sendCalResultMessage(result.toString());
    }
}

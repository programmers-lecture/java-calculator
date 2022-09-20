import calculator.PostfixCalculator;
import converter.FormConverter;
import view.Sender;

import java.util.List;
import java.util.Optional;

import static view.Reader.read;

public class MainApplication {

    public static void main(String[] args) {
        List<String> formulaList = new FormConverter().getFormula(read());
        Optional<Integer> result = new PostfixCalculator().getResult(formulaList);
        Sender.sendCalResultMessage(result.orElseThrow(NullPointerException::new).toString());
    }
}

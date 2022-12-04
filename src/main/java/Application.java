import utils.StringParser;
import view.InputView;
import view.OutputView;

import java.io.IOException;
import java.util.List;

public class Application {
    private static final int FIRST_NUMBER_INDEX=0;
    private static final int SECONDE_NUMBER_INDEX=2;
    private static final int OPERATION_INDEX=1;
    public static void main(String[] args) throws IOException {
        String input=InputView.inputTarget();
        List<String>inputList= StringParser.parseInput(input);
        Calculator calculator=new Calculator(inputList.get(FIRST_NUMBER_INDEX),inputList.get(SECONDE_NUMBER_INDEX),inputList.get(OPERATION_INDEX));
        OutputView.result(calculator.calculateNumber());
    }
}

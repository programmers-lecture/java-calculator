import utils.StringParser;
import view.InputView;
import view.OutputView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) throws IOException {
        String input=InputView.inputTarget();
        List<String>inputList= StringParser.parseInput(input);
        List<String>operandList=StringParser.parseOperand(inputList);
        List<String>operatorList=StringParser.parseOperator(inputList);
        Result result=new Result();
        for(int index=0;index<operandList.size();index++){
            Calculator calculator=new Calculator(result.getResult(index),operandList.get(index),operatorList.get(index));
            result.addResultList(calculator.calculateNumber());
        }
        OutputView.result(result.getResult(result.resultListLastNumber()));
    }
}

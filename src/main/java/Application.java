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
        List<Integer>resultList=new ArrayList<>();
        resultList.add(0);
        for(int index=0;index<operandList.size();index++){
            Calculator calculator=new Calculator(resultList.get(index),operandList.get(index),operatorList.get(index));
            resultList.add(calculator.calculateNumber());
        }
        OutputView.result(resultList.get(resultList.size()-1));
    }
}

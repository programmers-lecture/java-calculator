import calculator.Calculator;
import view.Reader;

import java.util.List;

public class MainApplication {

    public static void main(String[] args) {
        List<String> list = Reader.read();
        Integer result = new Calculator().getResult(list);
        System.out.println("result = " + result);
    }
}

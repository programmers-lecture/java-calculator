import calculator.Calculator;
import operator.OperatorRepository;
import view.Reader;


public class MainApplication {

    public static void main(String[] args) {
        Integer result = new Calculator(new OperatorRepository()).getResult(Reader.read());
//        System.setIn(new InflaterInputStream(""));
        System.out.println("결과 : " + result);
    }
}

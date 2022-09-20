import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class DataHandler {
    private String inputString;
    private final Queue<String> operators = new LinkedList<>();
    private final Queue<Integer> operands = new LinkedList<>();

    public DataHandler(String inputString) {
        this.inputString = inputString;
    }

    // TODO: getter setter 제거
    public String getInputString() {
        return inputString;
    }

    public void setInputString(String inputString) {
        this.inputString = inputString;
    }

    // TODO: getter setter를 쓰는 것이 아니라 로직을 구현 (디미터의 법칙)
    public void processingData() {
        String[] dataArray = inputString.split(" ");

        for (String element : dataArray) {
            if (isOperator(element)) {
                operators.add(element);
                continue; // else를 쓰지 않으려고 하다 보니 어색해진 문장
            }
            operands.add(Integer.valueOf(element));
        }
    }

    private static boolean isOperator(String data) {
        for (Operator operator : Operator.values()) {
            System.out.println(operator.getOPERATOR() + " : " + data + " " + operator.getOPERATOR().equals(data));
            if (operator.getOPERATOR().equals(data)) {
                return true;
            }
        }
        return false;
    }

    public void print() {
        System.out.println(operands);
        System.out.println(operators);
    }
//    public Integer calculate() {
//        while
//    }
}

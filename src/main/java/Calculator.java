import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Calculator {

    private List<String> formula;
    private double result;

    // insertFormula : 계산할 공식을 계산기에 입력한다
    public void insertFormula() {
        Scanner scanner = new Scanner(System.in);
        // Arrays.asList()는 고정된 사이즈를 return 하기 때문에, remove/add 와 같이 사이즈를 변경하는 작업을 진행할 수 없다.
        // 따라서 new ArrayList<>()로 Arrays.asList()를 감싸서 고정된 길이가 아닌 가변의 길이에서 split 배열을 복사해 생성한다.
        this.formula = new ArrayList<>(Arrays.asList(scanner.nextLine().split(" ")));
    }

    // preProcess : 공식 계산 전 사칙연산 우선순위를 적용한다.
    public void preProcessFormula() {
        // *,/가 먼저 진행되고 +과 -이 진행되도록 한다.
        for(int i=1; i<formula.size(); i++) {
            String operator = formula.get(i);
            if(operator.equals("*")) {
                fetchToFormula(i, Double.parseDouble(formula.get(i-1)) * Double.parseDouble(formula.get(i+1)));
                i -= 1;
            } else if(operator.equals("/")) {
                fetchToFormula(i, Double.parseDouble(formula.get(i-1)) / Double.parseDouble(formula.get(i+1)));
                i -= 1;
            }
        }
    }

    // fetchToFormula : 먼저 계산된 *와 /에 대해 계산식에서 정리한다.
    private void fetchToFormula(int position, double operand) {
        formula.set(position, String.valueOf(operand));
        formula.remove(position-1);
        formula.remove(position);
    }

    // run : 계산을 실행
    public void run() {
        double result = Double.parseDouble(formula.get(0));

        for(int i=1; i<formula.size(); i+=2) {
            String operator = formula.get(i);
            if(operator.equals("+")) {
                result += Double.parseDouble(formula.get(i+1));
            } else if(operator.equals("-")) {
                result -= Double.parseDouble(formula.get(i+1));
            }
        }
         this.result = result;
    }

    // 결과 반환
    public double getResult() {
        return this.result;
    }

}

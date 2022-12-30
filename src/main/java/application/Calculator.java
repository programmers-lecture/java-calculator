package application;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Calculator {

    private List<String> expression;
    private Double result;

    // toDouble : String을 Double로 바꾼다
    public static Double toDouble(String value) {
        return Double.parseDouble(value);
    }

    // parseExpression : 계산식을 list 에 저장한다
    public void parseExpression(String[] exprTokens) {
        // Arrays.asList()는 고정된 사이즈를 return 하기 때문에, remove/add 와 같이 사이즈를 변경하는 작업을 진행할 수 없다.
        // 따라서 new ArrayList<>()로 Arrays.asList()를 감싸서 고정된 길이가 아닌 가변의 길이에서 split 배열을 복사해 생성한다.
        this.expression = new ArrayList<>(Arrays.asList(exprTokens));
    }

    // run : 계산을 실행
    public void run() {
        // TODO : 연산자 우선순위에 따른 계산은 어떻게 처리해야 할까?
        // 계산
        result = toDouble(expression.get(0));

        for(int i = 1; i < expression.size(); i += 2) {
            String operator = expression.get(i);
            Double operand = toDouble(expression.get(i+1));
            result = Operator.calculate(operator, result, operand);
        }
    }

    // 결과 반환
    public Double getResult() {
        return this.result;
    }

}

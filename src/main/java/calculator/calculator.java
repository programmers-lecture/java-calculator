package calculator;
import calculator.view.calculatorView;

public class calculator {
    public static void main(String[] args) {
        calculatorView view = new calculatorView();
        String[] inputNum = view.input();

        int tmp = 0;                                // 계산 결과값 저장 변수
                                                    // view의 output()의 인자로 넘겨져 계산 결과 값이 출력됨

        for(int i = 0; i < inputNum.length; i++) {
            // 첫 연산자라면, 연산자 앞뒤 정수들과 계산 후 tmp에 값 저장
            if (i == 1) {
                if (inputNum[i].equals("+")) {
                    tmp += Integer.parseInt(inputNum[i - 1]) + Integer.parseInt(inputNum[i + 1]);
                } else if (inputNum[i].equals("-")) {
                    tmp += Integer.parseInt(inputNum[i - 1]) - Integer.parseInt(inputNum[i + 1]);
                } else if (inputNum[i].equals("/")) {
                    tmp += Integer.parseInt(inputNum[i - 1]) / Integer.parseInt(inputNum[i + 1]);
                } else {
                    tmp += Integer.parseInt(inputNum[i - 1]) * Integer.parseInt(inputNum[i + 1]);
                }
            }
            // TODO: 사착연산 우선순위 구현 필요
            // tmp 값과 연산자 다음 정수와 계산
            else if(i % 2 == 1) {
                if (inputNum[i].equals("+")) {
                    tmp += Integer.parseInt(inputNum[i + 1]);
                } else if (inputNum[i].equals("-")) {
                    tmp -= Integer.parseInt(inputNum[i + 1]);
                } else if (inputNum[i].equals("/")) {
                    tmp /= Integer.parseInt(inputNum[i + 1]);
                } else {
                    tmp *= Integer.parseInt(inputNum[i + 1]);
                }
            }
        }
        view.output(tmp);
    }
}

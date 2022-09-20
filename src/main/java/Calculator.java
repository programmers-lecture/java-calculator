import view.InputView;
import view.OutputView;

import java.util.Arrays;

/**
 * 프로그램 실행 제어
 */
public class Calculator {
    static final InputView INPUT_VIEW = new InputView();
    static final OutputView OUTPUT_VIEW = new OutputView();
    static DataHandler dataHandler;

    public Calculator() {
        System.out.println("문자열 계산기 프로그램을 실행합니다... ('0'을 입력하여 종료)");
    }

    public void run() {
        while (true) {
            // 입력
            dataHandler = new DataHandler(INPUT_VIEW.read());

            if (checkExit()) { // TODO: 메서드 추출 or 분리 (원칙: depth는 1까지만 허용)
                System.out.println(OUTPUT_VIEW.exit());
                return;
            }

            // 입력된 문자열을 공백단위로 분리하고, 연산자와 피연산자를 구분
            dataHandler.processingData();

            // 출력
//            Integer product = dataHandler.calculate();
//            OutputView.print(product);
        }
    }

    private boolean checkExit() {
        return dataHandler.getInputString().equals("0"); // TODO: 한 줄에 점 하나(디미터 법칙 참고)
    }
}

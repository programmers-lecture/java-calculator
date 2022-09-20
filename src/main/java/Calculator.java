import view.InputView;
import view.OutputView;

/**
 * 프로그램 실행 제어
 */
public class Calculator {
    static final InputView INPUT_VIEW = new InputView();
    static final OutputView OUTPUT_VIEW = new OutputView();

    public Calculator() {
        System.out.println("문자열 계산기 프로그램을 실행합니다... ('0'을 입력하여 종료)");
    }

    public void run() {
        while (true) {
            // 입력
            String inputString = INPUT_VIEW.read();

            if(checkExit(inputString)) { // TODO: 메서드 추출 or 분리 (depth는 1까지만 허용)
                System.out.println(OUTPUT_VIEW.exit());
                return;
            }

            // 입력된 문자열을 공백단위로 분리하고, 연산자와 피연산자를 구분


           // 출력

        }
    }

    private boolean checkExit(String order) {
        return order.equals("0");
    }
}

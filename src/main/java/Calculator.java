import view.InputView;
import view.OutputView;

public class Calculator {
    static final InputView INPUT_VIEW = new InputView();
    static final OutputView OUTPUT_VIEW = new OutputView();

    public Calculator() {
        System.out.println("문자열 계산기 프로그램을 실행합니다... ('0'을 입력하여 종료)");
    }

    public void run() {
        INPUT_VIEW.run();
        exit();
    }

    public void exit() {
        System.out.println("프로그램을 종료합니다...");
    }
}

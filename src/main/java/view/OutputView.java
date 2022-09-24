package view;

public class OutputView {
    private static final String EXIT_MESSAGE = "프로그램을 종료합니다...";

    public void printExitMessage() {
        System.out.println(EXIT_MESSAGE);
    }

    public void printCalculationResult(Integer result) {
        System.out.printf("결과는 %d%s", result, System.lineSeparator());
    }
}

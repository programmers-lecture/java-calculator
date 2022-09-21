package application;

public class OutputView {
    static final String EXIT_MESSAGE = "프로그램을 종료합니다...";

    public String exit() {
        return EXIT_MESSAGE;
    }

    public void print(Integer result) {
        System.out.printf("결과는 %d\n", result);
    }
}

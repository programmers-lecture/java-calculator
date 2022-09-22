package view;

public class InputView {
    private static final String WELCOME_MESSAGE = "프로그램을 시작합니다... ('0'을 입력하여 종료)";
    private static final String GUIDE_MESSAGE = "수식 입력 > ";

    public void printWelcomeMessage() {
        System.out.println(WELCOME_MESSAGE);
    }

    public void printGuideMessage() {
        System.out.print(GUIDE_MESSAGE);
    }
}

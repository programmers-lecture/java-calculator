package view;

import java.util.Scanner;

public class InputView {
    private static final String WELCOME_MESSAGE = "프로그램을 시작합니다... ('0'을 입력하여 종료)";
    private static final String GUIDE_MESSAGE = "수식 입력 > ";
    private final Scanner scanner = new Scanner(System.in);

    private void printWelcomeMessage() {
        System.out.println(WELCOME_MESSAGE);
    }

    private void printGuideMessage() {
        System.out.print(GUIDE_MESSAGE);
    }

    private String read() {
        return scanner.nextLine();
    }

    public String getFirstExpression() {
        printWelcomeMessage();
        return getNewExpression();
    }

    public String getNewExpression() {
        printGuideMessage();
        String expression = read();

        if (isExitOrder(expression)) {
            return null;
        }

        return expression;
    }

    private boolean isExitOrder(String order) {
        return order.equals("0");
    }
}

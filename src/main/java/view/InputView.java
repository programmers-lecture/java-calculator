package view;

import java.util.Scanner;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);

    public void run() {
        while (true) {
            System.out.print("수식 입력 > ");
            String inputString = SCANNER.nextLine();

            if (checkExitOrder(inputString)) { // TODO: 메서드 분리
                return;
            }
        }
    }

    private boolean checkExitOrder(String inputString) {
        return inputString.equals("0");
    }
}

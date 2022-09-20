package view;

import java.util.Scanner;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);

    public String read() {
        System.out.print("수식 입력 > ");
        return SCANNER.nextLine();
    }

    private boolean isExitOrder(String inputString) {
        return inputString.equals("0");
    }
}

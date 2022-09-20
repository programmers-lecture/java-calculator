package caculator.views;

import java.util.Scanner;

public class InputView {
    private static Scanner scanner = new Scanner(System.in);

    public static String[] inputFormula() {
        System.out.println("계산식을 입력해주세요 : ");
        String formula = scanner.nextLine();
        return formula.split(" ");
    }

}

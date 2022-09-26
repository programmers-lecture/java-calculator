package caculator.views;

import java.util.Scanner;

public class InputView {
    private InputView() {}

    public static String[] inputFormula() {
        System.out.println("계산식을 입력해주세요 : ");
        Scanner scanner = new Scanner(System.in);
        String formula = scanner.nextLine();
        return formula.split(" ");
    }

}

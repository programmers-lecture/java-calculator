package calculator.view;

import java.util.Scanner;

public class InputView {

    private static Scanner scanner = new Scanner(System.in);

    public static String[] inputFormula(){
        return scanner.nextLine().split(" ");
    }

}

package calculator.view;

import java.util.Scanner;

public class InputViewImpl implements InputView{

    private static Scanner scanner = new Scanner(System.in);

    public String[] inputFormula(){
        return scanner.nextLine().split(" ");
    }

}

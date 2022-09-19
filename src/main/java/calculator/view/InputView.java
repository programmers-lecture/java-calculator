package calculator.view;

import java.util.Scanner;

public class InputView {

    public String[] inputFormula(){
        Scanner sc = new Scanner(System.in);
        String inputValue=sc.nextLine();
        String[] values = inputValue.split(" ");
        return values;
    }
}

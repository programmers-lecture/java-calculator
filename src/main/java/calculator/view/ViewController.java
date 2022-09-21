package calculator.view;

import java.util.Scanner;

public class ViewController {

    public String[] inputView(){
        Scanner sc = new Scanner(System.in);
        String inputValue = sc.nextLine();
        String[] values = inputValue.split(" ");
        return values;
    }

    public void outputView(double result){
        System.out.println(result);
    }
}

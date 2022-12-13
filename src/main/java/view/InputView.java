package view;

import java.util.Scanner;

public class InputView {
    public static String[] input(){
        Scanner scanner = new Scanner(System.in);
        String content= scanner.nextLine();
        return  content.split(" ");

    }
}

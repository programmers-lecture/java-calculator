package calculator;

import view.View;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        View view = new View();
        Calculator calculator = new Calculator();

        view.selectFinish();

        while (true){
            String input = scanner.nextLine();
            if(input.equals("finish")) break;
            view.result(calculator.start(input));
        }
    }
}

package application;

import application.calculator.Calculator;
import application.view.View;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        View view = new View();
        Scanner kb = new Scanner(System.in);
        Calculator calculator = new Calculator();
        view.printHowToEnd();
        while (true) {
            String input = kb.nextLine();
            if(input.equals("exit")) break;
            view.printResult(calculator.run(input));
        }
    }
}

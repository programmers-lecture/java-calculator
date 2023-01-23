package application;

import application.calculator.Calculator;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        Calculator calculator = new Calculator();
        System.out.println("exit을 입력하면 종료됩니다.");
        while (true) {
            String input = kb.nextLine();
            if(input.equals("exit")) break;
            System.out.println("결과 : " + calculator.run(input) + "\n");
        }
    }
}

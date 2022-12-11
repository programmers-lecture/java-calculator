import application.Calculator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        Scanner scanner = new Scanner(System.in);

        calculator.parseExpression(scanner.nextLine().split(" "));

        calculator.run();

        System.out.println(calculator.getResult());
    }
}

package stringCalculator;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        String[] input = receiveInput();
        int result = calculator.calculate(input);
        System.out.println("결과 : " + result);
    }

    public static String[] receiveInput() {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine().replaceAll("\\s+", " ");
        return input.split(" ");
    }
}

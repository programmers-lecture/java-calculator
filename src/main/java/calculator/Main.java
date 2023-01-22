package calculator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculator calculator;

        String value = scanner.nextLine();

        String[] values = value.split(" ");

        int result = Integer.parseInt(values[0]);

        for(int i = 0; i < values.length-2; i+=2){
            int firstNum = result;
            String operation = values[i+1];
            int secondNum = Integer.parseInt(values[i+2]);

            calculator = new Calculator(firstNum, secondNum, operation);

            result = calculator.calculate();
        }
        System.out.println("결과 : " + result);
    }
}

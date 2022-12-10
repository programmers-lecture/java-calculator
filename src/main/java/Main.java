import bigDecimalCalculator.BigDecimalCalculator;
import calculator.Calculator;
import calculator.CalculatorType;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Calculator calculator = new BigDecimalCalculator(CalculatorType.ARITHMETIC);

        Scanner sc = new Scanner(System.in);
        while(true){
            String input = sc.nextLine();
            calculator.calculate(input);
        }
    }
}

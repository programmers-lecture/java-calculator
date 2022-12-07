import bigDecimalCalculator.BigDecimalCalculator;
import calculator.Calculator;

import java.math.BigDecimal;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Calculator<BigDecimal> calculator = new BigDecimalCalculator().asArithmetic();

        Scanner sc = new Scanner(System.in);
        while(true){
            String input = sc.nextLine();
            calculator.calculate(input);
        }
    }
}

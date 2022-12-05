import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        calculator.insertFormula();
        double result = calculator.getResult();

        System.out.println(result);
    }
}

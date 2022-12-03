import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] inputTokens = scanner.nextLine().split(" ");

        Calculator calculator = new Calculator();
        double result = calculator.getResult(inputTokens);

        System.out.println(result);
    }
}

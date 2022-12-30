import java.util.Scanner;

public class Input {
    private Scanner scanner;

    public Input() {
        scanner = new Scanner(System.in);
    }

    public String[] getFormula() {
        System.out.println("계산 식을 입력하세요!!");

        final String input = scanner.nextLine();

        return input.split(" ");
    }
}

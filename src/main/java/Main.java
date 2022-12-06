import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.Scanner;

public class Main {

    static Deque<Integer> number = new ArrayDeque<>();
    static Deque<String> symbol = new ArrayDeque<>();
    static List<String> symbols = Arrays.asList("+", "-", "*", "/");

    public static void main(String[] args) {
        final String[] formula = getFolmula();

        for (int i = 0; i < formula.length; i++) {
            char ch = getCh(formula[i]);
            if (isNumber(ch)) {
                if (number.size() == 0) {
                    number.add((int) ch - 48);
                }
                if (number.size() == 1) {
                    if (symbol.size() == 1) {
                        final String popSymbol = symbol.pop();
                        final Integer firstNumber = number.pollFirst();
                        final Integer secondNumber = (int) ch - 48;

                        calculate(popSymbol, firstNumber, secondNumber);
                    }
                }
            }

            saveSymbol(ch);
        }

        System.out.println("계산 결과 : " + number.pollFirst());
    }

    private static void saveSymbol(final char ch) {
        if (symbols.contains(String.valueOf(ch))) {
            symbol.add(String.valueOf(ch));
        }
    }

    private static void calculate(final String popSymbol,
                                  final Integer firstNumber,
                                  final Integer secondNumber) {
        if (popSymbol.equals("+")) {
            number.addFirst(firstNumber + secondNumber);
        }

        if (popSymbol.equals("*")) {
            number.add(firstNumber * secondNumber);
        }

        if (popSymbol.equals("-")) {
            number.add(firstNumber - secondNumber);
        }

        if (popSymbol.equals("/")) {
            number.add(firstNumber / secondNumber);
        }
    }

    private static boolean isNumber(final char ch) {
        return ch >= '0' && ch <= '9';
    }

    private static char getCh(final String formula) {
        return formula.charAt(0);
    }

    private static String[] getFolmula() {
        System.out.println("계산 식을 입력하세요!!");

        Scanner scanner = new Scanner(System.in);
        final String input = scanner.nextLine();

        return input.split(" ");
    }
}

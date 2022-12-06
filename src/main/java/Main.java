import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        final String[] formula = getFolmula();

        Deque<Integer> number = new ArrayDeque<>();
        Deque<String> symbol = new ArrayDeque<>();
        List<String> symbols = Arrays.asList("+", "-", "*", "/");

        for (int i = 0; i < formula.length; i++) {
            char ch = getCh(formula[i]);
            if (ch >= '0' && ch <= '9') {
                if (number.size() == 0) {
                    number.add((int) ch - 48);
                }
                if (number.size() == 1) {
                    //이미 숫자가 한 개 들어가 있으면
                    //심볼에 문자가 있는 지 확인하고
                    //있으면 계산한다.
                    if (symbol.size() == 1) {
                        final String popSymbol = symbol.pop();
                        final Integer firstNumber = number.pollFirst();
                        final Integer secondNumber = (int) ch - 48;

                        if (popSymbol.equals("+")) {
                            number.addFirst(firstNumber + secondNumber);
                        }

                        if (popSymbol.equals("*")) {
                            number.add(firstNumber * secondNumber);
                        }

                        if (popSymbol.equals("-")) {
                            number.add(firstNumber - secondNumber);
                        }

                        if (popSymbol.equals("/")) {;
                            number.add(firstNumber / secondNumber);
                        }
                    }
                }
            }

            if (symbols.contains(String.valueOf(ch))) {
                symbol.add(String.valueOf(ch));
            }

        }

        System.out.println("계산 결과 : " + number.pollFirst());
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

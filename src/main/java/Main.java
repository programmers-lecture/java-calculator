public class Main {

    private static Input input = new Input();
    private static Store<Integer> number = new Store<>();
    private static Store<String> symbol = new Store<>();
    private static Symbol symbols = new Symbol();

    private static Calculator calculator = new Calculator();

    public static void main(String[] args) {
        final String[] formula = input.getFormula();

        for (int i = 0; i < formula.length; i++) {
            char ch = getCh(formula[i]);
            if (isNumber(ch)) {
                if (number.isEmpty()) {
                    number.add((int) ch - 48);
                }

                if (number.sameSize(1)) {
                    if (symbol.sameSize(1)) {
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

}

public class Main {

    private static Input input = new Input();
    private static Number numbers = new Number();
    private static Symbol symbols = new Symbol();

    private static Calculator calculator = new Calculator();

    public static void main(String[] args) {
        final String[] formula = input.getFormula();

        for (int i = 0; i < formula.length; i++) {
            char ch = getCh(formula[i]);
            if (isNumber(ch)) {
                calculator.addNumber(ch);
            }

            if(calculator.canCalculate()) {
                final String popSymbol = symbols.pop();
                final Integer firstNumber = numbers.pollFirst();
                final Integer secondNumber = (int)ch - 48;

                final int calculate = calculator.calculate(popSymbol, firstNumber, secondNumber);
                numbers.add(calculate);
            }

            calculator.addSymbol(ch);
        }

        System.out.println("계산 결과 : " + numbers.pollFirst());
    }


    private static boolean isNumber(final char ch) {
        return ch >= '0' && ch <= '9';
    }

    private static char getCh(final String formula) {
        return formula.charAt(0);
    }

}

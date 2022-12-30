public class Main {

    private static Input input = new Input();
    private static Calculator calculator = new Calculator();

    public static void main(String[] args) {
        final String[] formula = input.getFormula();

        calculator.start(formula);

        calculator.showResult();
    }

}

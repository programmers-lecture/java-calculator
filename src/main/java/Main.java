public class Main {

    private static Input input = new Input();
    private static Number numbers = new Number();
    private static Symbol symbols = new Symbol();

    private static Calculator calculator = new Calculator();

    public static void main(String[] args) {
        final String[] formula = input.getFormula();

        calculator.start(formula);

        calculator.showResult();
    }

}

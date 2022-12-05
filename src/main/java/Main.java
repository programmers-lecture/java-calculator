public class Main {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();

        calculator.insertFormula();
        calculator.preProcessFormula();
        calculator.run();

        System.out.println(calculator.getResult());
    }
}

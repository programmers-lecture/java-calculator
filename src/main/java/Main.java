public class Main {
    public static void main(String[] args) {
        InputUtil inputUtil = new InputUtil();
        OutputUtil outputUtil = new OutputUtil();
        Calculator calculator = new Calculator();

        String input = inputUtil.inputStream();
        Double result = calculator.calculate(input);
        outputUtil.print(result);
    }
}

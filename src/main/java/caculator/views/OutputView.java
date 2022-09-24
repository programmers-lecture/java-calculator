package caculator.views;

public class OutputView {
    private OutputView() {}

    public static void printCalculatorResult(Double result) {
        System.out.println(result.doubleValue());
    }
}

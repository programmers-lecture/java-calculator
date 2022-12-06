public class Calculator {

    private final Store<Integer> number;
    private final Store<String> symbol;

    public Calculator() {
        this.number = new Store<>();
        this.symbol = new Store<>();
    }

    public void plus(int firstNum, int secondNum) {

    }

    public void minus(int firstNum, int secondNum) {

    }

    public void multiply(int firstNum, int secondNum) {

    }

    public void divide(int firstNum, int secondNum) {

    }

    public int getAnswer() {
        return this.number.pop();
    }
}

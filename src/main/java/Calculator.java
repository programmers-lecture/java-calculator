public class Calculator {
    //계산기 안에 Number, symbol이 들어가는 게 맞을까?
    //정말 계산만 하면되지 않을까?

    //calculate로 한 번에 계산 하는 게 나을까?
    //아니면 plus, minus처럼 의미를 명시해주는 게 나을까?

    private Number number;
    private Symbol symbol;

    public Calculator() {
        number = new Number();
        symbol = new Symbol();
    }



    public void addNumber(int number) {
        this.number.add(number);
    }

    public void addSymbol(char symbol) {
        this.symbol.add(String.valueOf(symbol));
    }

    public boolean canCalculate() {
        return this.number.sameSize(1) && this.symbol.sameSize(1);
    }

    public void showResult() {
        System.out.println("계산 결과 : " + this.number.getFirstNumber());
    }

    public void start(String[] formula) {
        for (int i = 0; i < formula.length; i++) {
            char ch = getCh(formula[i]);
            if (isNumber(ch)) {
                addNumber(ch);
            }

            if (canCalculate()) {
                final String popSymbol = symbol.getSymbol();
                final Integer firstNumber = number.getFirstNumber();
                final Integer secondNumber = (int) ch - 48;

                final int calculate = calculate(popSymbol, firstNumber, secondNumber);
                number.add(calculate);
            }

            addSymbol(ch);
        }
    }

    private boolean isNumber(final char ch) {
        return ch >= '0' && ch <= '9';
    }

    private char getCh(final String formula) {
        return formula.charAt(0);
    }

    public int calculate(String symbol, int firstNum, int secondNum) {
        //이것도 줄 일 수 있나
        if (symbol.equals("+")) {
            return plus(firstNum, secondNum);
        }

        if (symbol.equals("*")) {
            return multiply(firstNum, secondNum);
        }

        if (symbol.equals("-")) {
            return minus(firstNum, secondNum);
        }

        return divide(firstNum, secondNum);
    }

    private int plus(int firstNum, int secondNum) {
        return firstNum + secondNum;
    }

    private int minus(int firstNum, int secondNum) {
        return firstNum - secondNum;
    }

    private int multiply(int firstNum, int secondNum) {
        return firstNum * secondNum;
    }

    private int divide(int firstNum, int secondNum) {
        return firstNum / secondNum;
    }

}

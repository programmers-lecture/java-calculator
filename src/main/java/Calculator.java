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

    public void showResult() {
        System.out.println("계산 결과 : " + this.number.getFirstNumber());
    }

    public void start(String[] formula) {
        for (final String s : formula) {
            char ch = getCh(s);
            if (isNumber(ch)) {
                addNumber(ch);
            }

            if (canCalculate()) {
                final String popSymbol = symbol.getSymbol();
                final Integer firstNumber = number.getFirstNumber();
                final Integer secondNumber = getSecondNumber(ch);

                final int result = calculate(popSymbol, firstNumber, secondNumber);
                number.add(result);
            }

            addSymbol(ch);
        }
    }

    private void addNumber(char number) {
        this.number.add((int) number - 48);
    }

    private void addSymbol(char symbol) {
        this.symbol.add(String.valueOf(symbol));
    }

    private boolean canCalculate() {
        return this.number.sameSize(1) && this.symbol.sameSize(1);
    }

    private int getSecondNumber(final char ch) {
        return (int) ch - 48;
    }

    private boolean isNumber(final char ch) {
        return ch >= '0' && ch <= '9';
    }

    private char getCh(final String formula) {
        return formula.charAt(0);
    }

    private int calculate(String symbol, int firstNum, int secondNum) {
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

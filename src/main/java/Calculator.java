public class Calculator {

    //계산기 안에 Number, symbol이 들어가는 게 맞을까?
    //정말 계산만 하면되지 않을까?

    //calculate로 한 번에 계산 하는 게 나을까?
    //아니면 plus, minus처럼 의미를 명시해주는 게 나을까?

    public int calculate(String symbol, int firstNum, int secondNum) {
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

public class Operator {
    public Operator() {

    }
    public boolean isOperator(Character c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }

    public Double operate(Double a, Double b, Character c) throws ArithmeticException {
        switch (c) {
            case '+':
                a += b;
                break;
            case '-':
                a -= b;
                break;
            case '*':
                a *= b;
                break;
            case '/':
                try {
                    a /= b;
                } catch (ArithmeticException e) {
                    System.out.println("0으로 나눌 수 없습니다!"); // TODO : 더욱 깔끔한 예외처리?
                }
                break;
        }
        return a;
    }
}

public enum Operator {
    ADDITION("+") {
        @Override
        int calculate(int operand1, int operand2) {
            return operand1 + operand2;
        }
    },
    SUBTRACTION("-") {
        @Override
        int calculate(int operand1, int operand2) {
            return operand1 - operand2;
        }
    },
    MULTIPLICATION("*") {
        @Override
        int calculate(int operand1, int operand2) {
            return operand1 + operand2;
        }
    },
    DIVISION("/") {
        @Override
        int calculate(int operand1, int operand2) {
            return operand1 / operand2;
        }
    };

    protected final String OPERATOR;

    Operator(String operator) {
        OPERATOR = operator;
    }

    abstract int calculate(int operand1, int operand2); // 각 열거상수가 추상 메서드를 반드시 구현해야한다.
}

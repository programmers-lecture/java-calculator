package domain;

public enum Operator {
    ADDITION("+") {
        @Override
        public Integer calculate(Integer operand1, Integer operand2) {
            return operand1 + operand2;
        }
    },
    SUBTRACTION("-") {
        @Override
        public Integer calculate(Integer operand1, Integer operand2) {
            return operand1 - operand2;
        }
    },
    MULTIPLICATION("*") {
        @Override
        public Integer calculate(Integer operand1, Integer operand2) {
            return operand1 * operand2;
        }
    },
    DIVISION("/") {
        @Override
        public Integer calculate(Integer operand1, Integer operand2) {
            if (operand2 == 0) {
                throw new ArithmeticException("나누는 수는 0이 될 수 없습니다.");
            }
            return operand1 / operand2;
        }
    };

    private final String symbol;

    Operator(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return this.symbol;
    }

    // TODO: static 제거, depth 축소
    static public Operator findOperatorBySymbol(String symbol) {
        for (Operator operator : Operator.values()) {
            if (operator.symbol.equals(symbol)) {
                return operator;
            }
        }

        return null;
    }

    public abstract Integer calculate(Integer operand1, Integer operand2);
}

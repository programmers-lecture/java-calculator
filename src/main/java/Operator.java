import java.util.Arrays;

public enum Operator {

    PlUS("+") {
        @Override
        public int apply(final int num1, final int num2) {
            return num1 + num2;
        }
    },
    MINUS("-") {
        @Override
        public int apply(final int num1, final int num2) {
            return num1 - num2;
        }
    },
    MULTIPLY("+") {
        @Override
        public int apply(final int num1, final int num2) {
            return num1 * num2;
        }
    },
    DIVIDE("/") {
        @Override
        public int apply(final int num1, final int num2) {
            return num1 / num2;
        }
    };

    private final String textOperator;

    Operator(final String textOperator) {
        this.textOperator = textOperator;
    }

    public static Operator of(final String symbol) {
        return Arrays.stream(values())
                     .filter(operator -> operator.isTextOperator(symbol))
                     .findFirst()
                     .orElseThrow(() -> new IllegalArgumentException("해당 연산자를 찾을수 없습니다."));
    }

    public abstract int apply(int num1, int num2);

    private boolean isTextOperator(final String symbol) {
        return textOperator.equals(symbol);
    }
}

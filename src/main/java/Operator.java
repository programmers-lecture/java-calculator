import java.util.Arrays;

public enum Operator {
    PLUE("+") {
        @Override
        public Integer calculate (Integer a, Integer b){
            return a + b;
        }
    },

    MINUE("-") {
        @Override
        public Integer calculate (Integer a, Integer b){
            return a - b;
        }
    },

    DIVIDE("/") {
        @Override
        public Integer calculate (Integer a, Integer b){
            return a / b;
        }
    },

    MULTIPLE("*") {
        @Override
        public Integer calculate (Integer a, Integer b){
            return a * b;
        }
    };

    private static final String NOT_FOUND_OPERATOR = "존재하지 않는 사칙연산 입니다.";

    private String operation;

    Operator(String operation) {
        this.operation = operation;
    }

    public abstract Integer calculate(Integer a, Integer b);

    public Operator findOperation(String inputOperation) {
        return Arrays.stream(Operator.values())
                .filter(operator -> operation.equals(inputOperation))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(NOT_FOUND_OPERATOR));
    }

}
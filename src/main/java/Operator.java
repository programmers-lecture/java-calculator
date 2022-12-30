public enum Operator {
    PLUS("+") {
        public double apply(double x, double y) {
            return x + y;
        }
    },
    SUBTRACT("-") {
        public double apply(double x, double y) {
            return x - y;
        }
    },
    MULTIPLY("*") {
        public double apply(double x, double y) {
            return x * y;
        }
    },
    DIVIDE("/") {
        public double apply(double x, double y) {
            return x / y;
        }
    };

    private final String operator;

    Operator(String operator) {
        this.operator = operator;
    }



    public abstract double apply(double x, double y);
}

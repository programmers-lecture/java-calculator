package calculator.domain;

public enum Operator {
    PLUS("+",1){
        @Override
        public double apply(final double operand1, final double operand2){
            return operand1+operand2;
        }
    },
    MINUS("-",1){
        @Override
        public double apply(final double operand1, final double operand2){
            return operand1-operand2;
        }
    },
    MUL("*",2){
        @Override
        public double apply(final double operand1, final double operand2){
            return operand1*operand2;
        }
    },
    DIV("/",2){
        @Override
        public double apply(final double operand1, final double operand2){
            if(operand2==0){
                throw new IllegalArgumentException("0으로 나눌수 없습니다.");
            }
            return operand1/operand2;
        }
    };

    private final String textOperator;
    private final int priority;

    Operator(String textOperator, int priority){
        this.textOperator = textOperator;
        this.priority = priority;
    }

    public String getTextOperator() {
        return textOperator;
    }

    public int getPriority() {
        return priority;
    }

    public static Operator findOperator(String op) {

        if (PLUS.getTextOperator().equals(op)) {
            return PLUS;
        }
        if (MINUS.getTextOperator().equals(op)) {
            return MINUS;
        }
        if (MUL.getTextOperator().equals(op)) {
            return MUL;
        }
        return DIV;
    }

    public static int findPriority(String op) {

        if (PLUS.getTextOperator().equals(op)) {
            return PLUS.getPriority();
        }
        if (MINUS.getTextOperator().equals(op)) {
            return MINUS.getPriority();
        }
        if (MUL.getTextOperator().equals(op)) {
            return MUL.getPriority();
        }
        return DIV.getPriority();
    }


    public abstract double apply(double operand1, double operand2);
}

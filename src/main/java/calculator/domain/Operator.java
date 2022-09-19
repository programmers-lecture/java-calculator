package calculator.domain;

public enum Operator {
    PLUS("+"){
        @Override
        public double apply(final double operand1, final double operand2){
            return operand1+operand2;
        }
    },
    MINUS("-"){
        @Override
        public double apply(final double operand1, final double operand2){
            return operand1-operand2;
        }
    },
    MUL("*"){
        @Override
        public double apply(final double operand1, final double operand2){
            return operand1*operand2;
        }
    },
    DIV("/"){
        @Override
        public double apply(final double operand1, final double operand2){
            if(operand2==0){
                throw new IllegalArgumentException("0으로 나눌수 없습니다.");
            }
            return operand1/operand2;
        }
    };

    private final String textOperator;

    Operator(String textOperator){
        this.textOperator = textOperator;
    }

    public String getTextOperator() {
        return textOperator;
    }


    public abstract double apply(double operand1, double operand2);
}

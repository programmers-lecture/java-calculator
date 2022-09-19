package calculator.domain;

public enum Operator {
    PLUS("+"){
        @Override
        public int apply(final int operand1, final int operand2){
            return operand1+operand2;
        }
    },
    MINUS("-"){
        @Override
        public int apply(final int operand1, final int operand2){
            return operand1-operand2;
        }
    },
    MUL("*"){
        @Override
        public int apply(final int operand1, final int operand2){
            return operand1*operand2;
        }
    },
    DIV("/"){
        @Override
        public int apply(final int operand1, final int operand2){
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


    public abstract int apply(int operand1, int operand2);
}

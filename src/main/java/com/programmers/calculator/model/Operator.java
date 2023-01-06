package com.programmers.calculator.model;

public enum Operator {
    PLUS("+"){
        @Override
        public int calculate(int operand1, int operand2) {
            return operand1 + operand2;
        }
    }, MINUS("-"){
        @Override
        public int calculate(int operand1, int operand2) {
            return operand1 - operand2;
        }
    }, MULTIPLY("*"){
        @Override
        public int calculate(int operand1, int operand2) {
            return operand1 * operand2;
        }
    }, DIVISION("/"){
        @Override
        public int calculate(int operand1, int operand2) {
            if(operand2 == 0)
                throw new ArithmeticException("0으로 나눌 수 없습니다.");
            return operand1 / operand2;
        }
    };

    private String operator;
    Operator(String operator){
        this.operator = operator;
    }
    public abstract int calculate(int operand1, int operand2);
}

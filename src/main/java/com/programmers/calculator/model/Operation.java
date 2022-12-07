package com.programmers.calculator.model;

public class Operation {
    public int add(int operator1, int operator2) {
        return operator1 + operator2;
    }

    public int minus(int operator1, int operator2) {
        return operator1 - operator2;
    }

    public int multiple(int operator1, int operator2) {
        return operator1 * operator2;
    }

    public int divide(int operator1, int operator2) {
        if (operator2 == 0)
            throw new ArithmeticException("0으로 나눌 수 없습니다.");
        return operator1 / operator2;
    }

    public int toInt(String data) {
        return Integer.parseInt(data);
    }
}
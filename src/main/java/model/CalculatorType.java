package model;

import java.util.Arrays;
import java.util.Optional;
import java.util.function.BiFunction;

public enum CalculatorType {
    ADD("+",(left,right) -> left + right),
    SUBTRACT("-",(left,right) -> left - right),
    MULTIPLY("*", (left,right) -> left * right),
    // 나중에 분모 0 처리 방법 고민해보기
    DIVIDE("/", (left,right) -> left / right);

    private final BiFunction<Integer, Integer, Integer> process;
    private String operator;


    // <이전결과값, 연산해야할 값, 결과값> : process로 명칭
    CalculatorType(String operator, BiFunction<Integer,Integer,Integer> process) {
        this.operator = operator;
        this.process = process;
    }

    // 이전 결과값, 연산해야할 값
    public int operate(int oldResult, int currentValue){
        return process.apply(oldResult, currentValue);
    }


}


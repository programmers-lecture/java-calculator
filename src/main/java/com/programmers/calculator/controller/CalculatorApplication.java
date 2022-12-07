package com.programmers.calculator.controller;

import com.programmers.calculator.model.Calculator;
import com.programmers.calculator.view.InputView;
import com.programmers.calculator.view.OutputView;

public class CalculatorApplication {
    public void run() {
//      연산식 입력
        String[] expressions = new InputView().input();
//      연산식 계산
        Calculator calculator = new Calculator();
        int result = calculator.calculate(expressions);
//      연산식 출력
        new OutputView().print(result);

    }
}
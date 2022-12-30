package com.programmers.calculator.controller;

import com.programmers.calculator.model.Calculator;
import com.programmers.calculator.view.InputView;
import com.programmers.calculator.view.OutputView;

public class CalculatorApplication {
    public void run() {
        String[] expressions = InputView.input();
        Calculator calculator = new Calculator();
        int result = calculator.calculate(expressions);
        OutputView.print(result);
    }
}
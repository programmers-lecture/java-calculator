package controller;

import domain.Operator;
import org.junit.jupiter.api.Test;
import service.Calculator;
import service.Converter;
import view.InputView;
import view.OutputView;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ControllerTest {
    private final Converter converter = new Converter();
    private final Calculator calculator = new Calculator();
    private final OutputView outputView = new OutputView();

    @Test
    void 후위식_연산(){
        String expression = "1 + 2 * 3 / 0";

        ArrayList<String> postfix = converter.convertToPostfix(expression);
        Integer calculationResult = calculator.calculatePostfix(postfix);

        System.out.println("postfix = " + postfix);
        System.out.println("calculationResult = " + calculationResult);
        outputView.printCalculationResult(calculationResult);
    }
}
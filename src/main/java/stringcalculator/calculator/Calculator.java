package stringcalculator.calculator;

import stringcalculator.converter.FormConverter;

import java.util.List;

public interface Calculator {

    FormConverter formConverter = new FormConverter();

    int getResult(List<String> inputFormula);
}

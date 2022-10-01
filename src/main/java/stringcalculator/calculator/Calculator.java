package stringcalculator.calculator;

import stringcalculator.converter.FormConverter;

public interface Calculator {

    FormConverter formConverter = new FormConverter();

    int getResult();
}

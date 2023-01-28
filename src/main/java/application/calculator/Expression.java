package application.calculator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Expression {
    private final String[] expression;

    public Expression(String[] expression) {
        this.expression = expression;
    }

    public List<Double> getNumbers() {
        return Arrays.stream(expression)
                .filter(element -> element.compareTo("0") >= 0 && element.compareTo("9") <= 0)
                .map(str -> Double.valueOf(str))
                .collect(Collectors.toList());
    }

    public List<Operator> getOperators() {
        return Arrays.stream(expression)
                .filter(element -> !(element.compareTo("0") >= 0 && element.compareTo("9") <= 0))
                .map(str -> Operator.findOperator(str))
                .collect(Collectors.toList());
    }
}


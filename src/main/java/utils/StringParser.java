package utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringParser {
    private static final String INIT_OPERAND = "+";

    public static List<String> parseInput(String input) {
        return Arrays.asList(input.split(" "));
    }

    public static List<String> parseOperand(List<String> parseInput) {
        List<String> operandList = new ArrayList<>();
        for (int i = 0; i < parseInput.size(); i = i + 2) {
            operandList.add(parseInput.get(i));
        }
        return operandList;
    }

    public static List<String> parseOperator(List<String> parseInput) {
        List<String> operatorList = new ArrayList<>();
        for (int i = 1; i < parseInput.size(); i = i + 2) {
            operatorList.add(INIT_OPERAND);
            operatorList.add(parseInput.get(i));
        }
        return operatorList;
    }
}

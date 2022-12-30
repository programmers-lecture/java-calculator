package utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringUtils {
    private static final String INIT_OPERAND = "+";

    private static List<String> splitInput(String input) {
        return Arrays.asList(input.split(" "));
    }

    private static List<Integer>parseInteger(String input){
        return splitInput(input).stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
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

package stringcalculator.view;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static stringcalculator.exception.ExceptionMessage.FORMULA_NULL_ERROR;

public class Reader {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private Reader() {}

    public static List<String> read() {
        List<String> inputForms = null;
        try {
            String inputForm = br.readLine();
            inputForms = splitWithoutSpace(inputForm);
        } catch (Exception e) {
            throw new NullPointerException(FORMULA_NULL_ERROR.getMessage());
        }
        return inputForms;
    }

    public static List<String> splitWithoutSpace(String inputForm) {
        return Stream.of(splitEachChar(inputForm))
                .filter(Reader::isNotSpace)
                .collect(Collectors.toList());
    }

    private static boolean isNotSpace(String spell) {
        return !spell.equals(" ");
    }

    private static String[] splitEachChar(String inputForm) {
        return inputForm.split("");
    }

}

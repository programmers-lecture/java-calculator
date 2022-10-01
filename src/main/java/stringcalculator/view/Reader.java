package stringcalculator.view;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static stringcalculator.exception.ExceptionEnum.FORMULA_NULL_ERROR;
import static stringcalculator.exception.ExceptionEnum.throwException;

public class Reader {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static List<String> read() {
        List<String> inputForms = null;
        try {
            String inputForm = br.readLine();
            inputForms = splitWithoutSpace(inputForm);
        } catch (Exception e) {
            throwException(FORMULA_NULL_ERROR);
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

    private static boolean checkInputFormOk(String inputForm) {
        return Pattern
                .compile("^[0-9]*[+*/()-]*$")
                .matcher(inputForm)
                .find();
    }
}

package view;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Reader {
    final static private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static public List<String> read() {
        try {
            return splitWithoutSpace(br.readLine());
        } catch (Exception e) {
            throw new NullPointerException("입력이 부정확합니다.");
        }
    }

    static public List<String> splitWithoutSpace(String inputForm) {
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

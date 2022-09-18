package domain;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Reader {
    static private final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static public List<String> read() throws IOException {
        return Stream.of(br.readLine().split(""))
                .filter(Reader::isNotSpace)
                .collect(Collectors.toList());
    }

    private static boolean isNotSpace(String spell) {
        return !spell.equals(" ");
    }

}

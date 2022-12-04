package utils;

import java.util.Arrays;
import java.util.List;

public class StringParser {
    public static List<String> parseInput(String input){
        return Arrays.asList(input.split(" "));
    }
}

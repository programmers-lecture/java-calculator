import calculator.*;
import integerCalculator.IntegerSentenceParser;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        SentenceParser<Integer> sentenceParser = new IntegerSentenceParser();
        Calculator<Integer> sequentialCalculator = new SequentialCalculator<>(sentenceParser.parse(input));
        Calculator<Integer> arithmeticCalculator = new ArithmeticCalculator<>(sentenceParser.parse(input));

        Result<Integer> sequentialResult = new Result<>(sequentialCalculator.makeAnswer());
        sequentialResult.print();

        Result<Integer> arithmeticResult = new Result<>(arithmeticCalculator.makeAnswer());
        arithmeticResult.print();
    }
}

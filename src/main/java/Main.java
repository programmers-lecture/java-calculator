import calculator.Calculator;
import calculator.Result;
import calculator.SentenceParser;
import integerCalculator.IntegerCalculator;
import integerCalculator.IntegerSentenceParser;
import integerCalculator.IntegerSequentialCalculator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        SentenceParser<Integer> sentenceParser = new IntegerSentenceParser();
        Calculator<Integer> sequentialCalculator = new IntegerSequentialCalculator(sentenceParser.parse(input));
        Calculator<Integer> calculator = new IntegerCalculator(sentenceParser.parse(input));

        Result<Integer> sequentialResult = new Result<>(sequentialCalculator.makeAnswer());
        sequentialResult.print();

        Result<Integer> result = new Result<>(calculator.makeAnswer());
        result.print();
    }
}

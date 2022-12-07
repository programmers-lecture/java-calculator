import bigDecimalCalculator.BigDecimalSentenceParser;
import calculator.*;
import integerCalculator.IntegerSentenceParser;

import java.math.BigDecimal;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String inputForInteger = sc.nextLine();

        SentenceParser<Integer> sentenceParser = new IntegerSentenceParser();
        Calculator<Integer> sequentialCalculator = new SequentialCalculator<>(sentenceParser.parse(inputForInteger));
        Calculator<Integer> arithmeticCalculator = new ArithmeticCalculator<>(sentenceParser.parse(inputForInteger));

        Result<Integer> sequentialResult = new Result<>(sequentialCalculator.makeAnswer());
        sequentialResult.print();

        Result<Integer> arithmeticResult = new Result<>(arithmeticCalculator.makeAnswer());
        arithmeticResult.print();

        String inputForBigDecimal = sc.nextLine();

        SentenceParser<BigDecimal> bigDecimalSentenceParser = new BigDecimalSentenceParser();
        Calculator<BigDecimal> bigDecimalSequentialCalculator =
                new SequentialCalculator<>(bigDecimalSentenceParser.parse(inputForBigDecimal));
        Calculator<BigDecimal> bigDecimalArithmeticCalculator =
                new ArithmeticCalculator<>(bigDecimalSentenceParser.parse(inputForBigDecimal));

        Result<BigDecimal> bigDecimalSequentialResult = new Result<>(bigDecimalSequentialCalculator.makeAnswer());
        bigDecimalSequentialResult.print();

        Result<BigDecimal> bigDecimalArithmeticResult = new Result<>(bigDecimalArithmeticCalculator.makeAnswer());
        bigDecimalArithmeticResult.print();
    }
}

import bigDecimalCalculator.BigDecimalExpressionParser;
import calculator.Calculator;
import calculator.expression.Operand;
import calculator.parser.ExpressionParser;
import calculator.processor.ArithmeticProcessor;
import util.ResultPrinter;

import java.math.BigDecimal;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ExpressionParser<BigDecimal> bigDecimalExpressionParser = new BigDecimalExpressionParser();
        Calculator<BigDecimal> bigDecimalArithmeticCalculator = new Calculator<>(new ArithmeticProcessor<>());

        Scanner sc = new Scanner(System.in);
        while(true){
            String input = sc.nextLine();

            Operand<BigDecimal> result = bigDecimalArithmeticCalculator.calculate(
                    bigDecimalExpressionParser.parse(input));

            ResultPrinter.print(result);
        }
    }
}

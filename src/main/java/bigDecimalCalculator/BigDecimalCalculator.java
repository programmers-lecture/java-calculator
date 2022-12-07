package bigDecimalCalculator;

import calculator.Result;
import calculator.parser.SentenceParser;
import calculator.processor.ArithmeticProcessor;
import calculator.processor.Processor;
import calculator.processor.SequentialProcessor;
import calculator.Calculator;

import java.math.BigDecimal;

public class BigDecimalCalculator extends Calculator<BigDecimal> {

    @Override
    public void calculate(String input) {
        SentenceParser<BigDecimal> parser = new BigDecimalSentenceParser();
        Processor<BigDecimal> processor;
        switch (type) {
            case SEQUENTIAL:
                processor = new SequentialProcessor<>(parser.parse(input));
                new Result<>(processor.process()).print();
                return;
            case ARITHMETIC:
                processor = new ArithmeticProcessor<>(parser.parse(input));
                new Result<>(processor.process()).print();
                return;
            default:
                throw new IllegalStateException();
        }
    }
}

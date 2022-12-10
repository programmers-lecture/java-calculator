package bigDecimalCalculator;

import calculator.CalculatorType;
import calculator.Result;
import calculator.parser.SentenceParser;
import calculator.processor.ArithmeticProcessor;
import calculator.processor.Processor;
import calculator.processor.SequentialProcessor;
import calculator.Calculator;

import java.math.BigDecimal;

public class BigDecimalCalculator extends Calculator{

    public BigDecimalCalculator(CalculatorType type) {
        super(type);
    }

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

package integerCalculator;

import calculator.Result;
import calculator.parser.SentenceParser;
import calculator.processor.ArithmeticProcessor;
import calculator.processor.Processor;
import calculator.processor.SequentialProcessor;
import calculator.Calculator;

public class IntegerCalculator extends Calculator<Integer> {
    @Override
    public void calculate(String input) {
        SentenceParser<Integer> parser = new IntegerSentenceParser();
        Processor<Integer> processor;
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

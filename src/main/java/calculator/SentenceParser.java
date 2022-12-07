package calculator;

public interface SentenceParser<T> {
    Operand<T> parse(String sentence);
}

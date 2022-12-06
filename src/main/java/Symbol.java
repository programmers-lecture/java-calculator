import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Symbol {

    private Deque<String> symbols;

    public Symbol() {
        symbols = new ArrayDeque<>();
    }

    public boolean isSymbol(String symbol) {
        return Arrays.asList("+", "-", "*", "/").contains(symbol);
    }

    public void add(String symbol) {
        if (isSymbol(symbol)) {
            symbols.add(symbol);
        }

    }

    public String pop() {
        return symbols.pop();
    }

    public String pollFirst() {
        return symbols.pollFirst();
    }

    public int size() {
        return symbols.size();
    }

    public void addFirst(String value) {
        this.symbols.addFirst(value);
    }

    public boolean sameSize(int size) {
        return this.size() == size;
    }

    public boolean isEmpty() {
        return this.symbols.isEmpty();
    }

}

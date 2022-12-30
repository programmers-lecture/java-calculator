import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Symbols {

    private Deque<String> symbols;

    public Symbols() {
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

    public String getSymbol() {
        return symbols.pop();
    }

    public int size() {
        return symbols.size();
    }

    public boolean sameSize(int size) {
        return this.size() == size;
    }

}

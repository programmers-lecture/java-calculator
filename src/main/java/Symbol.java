import java.util.Arrays;
import java.util.List;

public class Symbol {

    private List<String> symbols;

    public Symbol() {
        symbols = Arrays.asList("+", "-", "*", "/");
    }

    public boolean contains(String symbol) {
        return symbols.contains(symbol);
    }

}

import java.util.ArrayDeque;
import java.util.Deque;

public class Numbers {

    private Deque<Integer> numbers;

    public Numbers() {
        this.numbers = new ArrayDeque<>();
    }

    public void add(Integer number) {
        if (numbers.isEmpty()) {
            numbers.add(number);
        }
    }

    public Integer getFirstNumber() {
        return numbers.pollFirst();
    }

    public int size() {
        return numbers.size();
    }

    public boolean sameSize(int size) {
        return this.size() == size;
    }

}

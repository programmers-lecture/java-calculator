import java.util.ArrayDeque;
import java.util.Deque;

public class Number {

    private Deque<Integer> numbers;

    public Number() {
        this.numbers = new ArrayDeque<>();
    }

    public void add(Integer number) {
        if(numbers.isEmpty()) {
            numbers.add(number);
        }
    }

    public Integer pop() {
        return numbers.pop();
    }

    public Integer pollFirst() {
        return numbers.pollFirst();
    }

    public int size() {
        return numbers.size();
    }

    public void addFirst(Integer value) {
        this.numbers.addFirst(value);
    }

    public boolean sameSize(int size) {
        return this.size() == size;
    }

    public boolean isEmpty() {
        return this.numbers.isEmpty();
    }
}

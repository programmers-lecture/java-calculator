import java.util.ArrayDeque;
import java.util.Deque;

public class Store<T> {

    private Deque<T> deque;

    public Store() {
        deque = new ArrayDeque<>();
    }

    public void add(T number) {
        deque.add(number);
    }

    public T pop() {
        return deque.pop();
    }

    public T pollFirst() {
        return deque.pollFirst();
    }

    public int size() {
        return deque.size();
    }

    public void addFirst(T value) {
        this.deque.addFirst(value);
    }

    public boolean sameSize(int size) {
        return this.size() == size;
    }

    public boolean isEmpty() {
        return this.deque.isEmpty();
    }

}

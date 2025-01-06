import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class SortTask implements Runnable {
    private final List<Integer> numbers;
    private final AtomicBoolean sorted;

    public SortTask(List<Integer> numbers, AtomicBoolean sorted) {
        this.numbers = numbers;
        this.sorted = sorted;
    }

    @Override
    public void run() {
        while (!sorted.get()) {
            sorted.set(true);
            for (int i = 0; i < numbers.size() - 1; i++) {
                synchronized (numbers) {
                    if (numbers.get(i) > numbers.get(i + 1)) {
                        // Swap elements
                        int temp = numbers.get(i);
                        numbers.set(i, numbers.get(i + 1));
                        numbers.set(i + 1, temp);
                        sorted.set(false);
                    }
                }
            }
        }
    }
}
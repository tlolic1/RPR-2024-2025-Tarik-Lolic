import java.util.List;
import java.util.concurrent.Callable;

public class SearchTask implements Callable<Boolean> {
    private final List<Integer> numbers;
    private final int target;
    private final int start;
    private final int end;

    public SearchTask(List<Integer> numbers, int target, int start, int end) {
        this.numbers = numbers;
        this.target = target;
        this.start = start;
        this.end = end;
    }

    @Override
    public Boolean call() {
        for (int i = start; i < end; i++) {
            if (numbers.get(i) == target) {
                return true;
            }
        }
        return false;
    }
}
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;

public class Main {
    public static void main(String[] args) {
        int numElements = 1000;
        int numThreads = 50;
        List<Integer> numbers = new ArrayList<>(numElements);
        Random random = new Random();

        for (int i = 0; i < numElements; i++) {
            numbers.add(random.nextInt(1001));
        }

        ExecutorService executor = Executors.newFixedThreadPool(numThreads);
        AtomicBoolean sorted = new AtomicBoolean(false);

        for (int i = 0; i < numThreads; i++) {
            executor.submit(new SortTask(numbers, sorted));
        }

        executor.shutdown();
        while (!executor.isTerminated()) {

        }

        System.out.println(numbers);
    }
}
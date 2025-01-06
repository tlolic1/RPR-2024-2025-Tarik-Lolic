import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) {
        int numElements = 100_000_000;
        int numThreads = 16;
        List<Integer> numbers = new ArrayList<>(numElements);
        Random random = new Random();

        // Popunjavanje kolekcije nasumičnim brojevima
        for (int i = 0; i < numElements; i++) {
            numbers.add(random.nextInt(1001));
        }

        // Nasumični broj za pretragu
        int target = numbers.get(random.nextInt(numElements));

        // Kreiranje ExecutorService sa 16 niti
        ExecutorService executor = Executors.newFixedThreadPool(numThreads);
        List<Future<Boolean>> futures = new ArrayList<>();

        // Dodjeljivanje zadataka nitima
        int chunkSize = numElements / numThreads;
        for (int i = 0; i < numThreads; i++) {
            int start = i * chunkSize;
            int end = (i == numThreads - 1) ? numElements : start + chunkSize;
            futures.add(executor.submit(new SearchTask(numbers, target, start, end)));
        }

        // Provjera rezultata
        try {
            for (Future<Boolean> future : futures) {
                if (future.get()) {
                    System.out.println("Broj " + target + " je pronađen.");
                    break;
                }
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } finally {
            executor.shutdown();
        }
    }
}
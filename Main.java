import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static AtomicInteger brojac = new AtomicInteger();
    public static List<Integer> brojevi = new ArrayList<Integer>();
    public static void main(String[] args) {
        brojac.set(0);
        List<Thread> niti = new ArrayList<Thread>();
        for (int i = 0; i < 32; i++) {
            niti.add(new BrojacNit());
            niti.get(i).start();
        }
        try {
            for (Thread nit : niti)
                nit.join();
            System.out.print(brojevi);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}

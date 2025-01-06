public class BrojacNit extends Thread
{
    public synchronized void run () {
        for (int j = 0; j < 1000; j++) {
            Main.brojevi.add(Main.brojac.incrementAndGet());
        }
    }
}

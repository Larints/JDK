import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class Table {

    private Fork[] forks;

    private Philosopher[] philosophers;



    public Table() {
        forks = new Fork[5];
        for (int i = 0; i < 5; i++) {
            forks[i] = new Fork();
        }
        philosophers = new Philosopher[5];
        addPhilosopher();
    }

    private void addPhilosopher() {
        for (int i = 0; i < philosophers.length; i++) {
            Fork left = forks[i];
            Fork right = forks[(i + 1) % forks.length];
            if (i == philosophers.length - 1) philosophers[i] = new Philosopher(String.valueOf(i + 1), right, left);
            else       philosophers[i] = new Philosopher(String.valueOf(i + 1), left, right);

        }
    }

    public void startDinner() throws InterruptedException {
        for (Philosopher philosopher : philosophers) {
            new Thread(philosopher).start();
        }
    }
}

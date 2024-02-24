import java.util.concurrent.CountDownLatch;

public class Philosopher implements Runnable {

    private String name;

    private final Fork left;

    private final Fork right;

    private int count = 1;

    public Philosopher(String name, Fork left, Fork right) {
        this.name = name;
        this.left = left;
        this.right = right;

    }


    public void eat() throws InterruptedException {
        synchronized (left) {
            System.out.println(name + " философ поднял левую вилку");
        }
        synchronized (right) {
            System.out.println(name + " философ поднял правую вилку - кушает");
            System.out.println(name + " философ положил правую вилку.");
        }

        System.out.println(name + " философ положил левую вилку. Возвращается к размышлению");
        System.out.println(name + " философ поел " + count++ + " раз" );

    }

    @Override
    public void run() {
        for (int i = 0; i <3; i++) {
            try {
                eat();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println(name + " закончил кушать");
    }

}

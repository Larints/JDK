import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Paradox {

    private static final List<Boolean> changeChoice;

    private static final List<Boolean> notChangeChoice;

    private static final Random rand;


    static {
        changeChoice = new ArrayList<>();
        notChangeChoice = new ArrayList<>();
        rand = new Random();
    }

    private static void game() {
        boolean[] game = new boolean[3];
        int prizeDoor = rand.nextInt(3);
        game[prizeDoor] = true;
        int choice = rand.nextInt(game.length);
        boolean changed = rand.nextInt(2) == 1;
        if (changed) {
            int nextChoice;
            do {
                nextChoice = rand.nextInt(game.length);
            }
            while (nextChoice == choice);
            changeChoice.add(game[nextChoice]);
        }
        else {
            notChangeChoice.add(game[choice]);
        }
    }

    public static void startGame() {
        for (int i = 0; i < 100000; i++) {
            game();
        }
        gameAnalysis();
    }

    private static void gameAnalysis() {
        System.out.println("Когда игрок сменил изначальный выбор: " + changeChoice.stream().filter(choice -> choice).count());
        System.out.println("Когда игрок не менял изначальный выбор: " + notChangeChoice.stream().filter(choice -> choice).count());
    }
}

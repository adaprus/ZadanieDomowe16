import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test {
    private static Scanner scanner = new Scanner(System.in);
    private static List<Player> players;
    private static File file = new File("wyniki.csv");

    public static void main(String[] args) {

        try {
            players = createPlayersList();
            players.sort(new ScoreComparator());
            saveScores();
        } catch (IllegalArgumentException | NullPointerException | IOException | ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
    }

    private static List<Player> createPlayersList() {
        System.out.println("Podaj wynik gracza lub STOP:");
        String line = scanner.nextLine();
        List<Player> players = new ArrayList<>();
        String[] data;

        while (!line.equals("STOP")) {
            data = line.split(" ");
            Player player = new Player();
            player.setFirstName(data[0]);
            player.setLastName(data[1]);
            player.setScore(Integer.valueOf(data[2]));
            players.add(player);
            System.out.println("Podaj wynik gracza lub STOP:");
            line = scanner.nextLine();
        }
        return players;
    }

    private static void saveScores() throws IOException {
        BufferedWriter br = new BufferedWriter(new FileWriter(file));
        for (Player player : players) {
            br.write(player.getFirstName() + ";" + player.getLastName() + ";" + player.getScore());
            br.newLine();
            br.flush();
        }
        br.close();
    }
}

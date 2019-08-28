import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test {
    private static Scanner scanner = new Scanner(System.in);
    private static File file = new File("wyniki.csv");

    public static void main(String[] args) {

        try {
            List<Player> players = createPlayersList();
            players.sort(new ScoreComparator());
            try {
                saveScores(players);
            } catch (IOException e){
                System.err.println("Bład pliku");
            }
        } catch (IllegalArgumentException | ArrayIndexOutOfBoundsException e) {
            System.out.println("Wprowadź poprawne dane");
        }
    }

    private static List<Player> createPlayersList() {
        System.out.println("Podaj wynik gracza (w formacie IMIE NAZWISKO WYNIK) lub STOP:");
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
            System.out.println("Podaj wynik gracza (w formacie IMIE NAZWISKO WYNIK) lub STOP:");
            line = scanner.nextLine();
        }
        return players;
    }

    private static void saveScores(List<Player> players) throws IOException {
        BufferedWriter br = new BufferedWriter(new FileWriter(file));
        for (Player player : players) {
            br.write(player.getFirstName() + ";" + player.getLastName() + ";" + player.getScore());
            br.newLine();
            br.flush();
        }
        br.close();
    }
}
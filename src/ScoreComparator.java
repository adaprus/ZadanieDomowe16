import java.util.Comparator;

public class ScoreComparator implements Comparator<Player> {
    @Override
    public int compare(Player o1, Player o2) {
        if (o1 == null && o2 == null) {
            return 0;
        } else if (o1 == null && o2 != null) {
            return -1;
        } else if (o1 != null && o2 == null) {
            return 1;
        }
        return Integer.compare(o2.getScore(), o1.getScore());
    }
}

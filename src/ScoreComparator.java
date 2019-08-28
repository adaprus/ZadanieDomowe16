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
        if (o2.getScore() > o1.getScore()) {
            return 1;
        }
        if (o2.getScore() < o1.getScore()) {
            return -1;
        }
        if (o2.getScore() == o2.getScore()) {
            if (o1.getLastName().equals(o2.getLastName())) {
                return o1.getFirstName().compareTo(o2.getFirstName());
            }
        }
        return o1.getLastName().compareTo(o2.getLastName());
    }
}

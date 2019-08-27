public class Player {
    private String firstName;
    private String lastName;
    private int score;

    public Player() {
    }

    public Player(String firstName, String lastName, int score) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.score = score;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if (firstName.equals(null)){
            throw new NullPointerException("Podaj poprawne imię");
        }
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if (lastName.equals(null)){
            throw new NullPointerException("Podaj poprawne nazwisko");
        }
        this.lastName = lastName;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        if(score < 0) {
            throw new IllegalArgumentException("Wynik gracza musi być liczbą nieujemną");
        }
        this.score = score;
    }
}

package chapter02;

public class BingoBall {
    private final char letter;
    private final int number;

    public BingoBall(int num) {
        number = num;

        if (num <= 15)
            letter = 'B';
        else if (num <= 30)
            letter = 'I';
        else if (num <= 45)
            letter = 'N';
        else if (num <= 60)
            letter = 'G';
        else
            letter = 'O';
    }

    public String toString() {
        return (letter + " " + number);
    }
}

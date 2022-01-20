package chapter02;

public class Bingo {
    public static void main(String[] args) {
        final int NUM_BALLS = 75, NUM_PULLS = 10;

        ArrayBag bingoBag = new ArrayBag();
        BingoBall ball;

        for (int num = 1; num <= NUM_BALLS; num++) {
            ball = new BingoBall((num));
            bingoBag.add(ball);
        }

        System.out.println("Size: " + bingoBag.size());
        System.out.println();

        for (int num = 1; num <= NUM_PULLS; num++) {
            try {
                ball = (BingoBall) bingoBag.removeRandom();
                System.out.println(ball);
            } catch (EmptyBagException e) {
                e.printStackTrace();
            }

        }
    }
}

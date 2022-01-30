package misc;

import java.util.Random;

public class PasswordGenerator {
    public static void main(String[] args) {
        PasswordGenerator passwordGenerator = new PasswordGenerator();
        int passwordLength = 16;

        String lower = "abcdefghijklmnopqrstuvwxyz";
        String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String numbers = "0123456789";
        String symbols = "[]{}()*;/,_-";

        String all = lower + upper + numbers + symbols;
        System.out.println("All characters: " + all);

        String password = passwordGenerator.myRandom(all, passwordLength);
        System.out.println("password: " + password);
    }

    public String myRandom(String input, int length)
    {
        StringBuilder stringBuilder = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < length; i++)
            stringBuilder.append(input.charAt(random.nextInt(input.length())));

        return stringBuilder.toString();
    }
}

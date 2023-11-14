import java.util.Random;
import java.util.Scanner;

public class Numbergame {

    public static void main(String[] args) {
        Random random = new Random();
        int RandNum = random.nextInt(100) + 1;
        Scanner sc = new Scanner(System.in);

        int Attempts = 1;
        System.out.println("Guess a number between 1 and 100: ");
        int userGuess = sc.nextInt();

        while (userGuess != RandNum) {
            if (userGuess > RandNum) {
                System.out.println("Your guess is too high.");
            } else {
                System.out.println("Your guess is too low.");
            }
            Attempts++;
            System.out.println("Guess a number between 1 and 100: ");
            userGuess = sc.nextInt();
        }
        int score = 100 - Attempts;
        System.out.println("Congratulations! You guessed the correct number: " + RandNum);
        System.out.println("Your score is: " + score);

        sc.close();
    }
}

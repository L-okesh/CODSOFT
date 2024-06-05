import java.util.Scanner;
import java.util.Random;

public class numberguessing {
    public static void main(String[] args) {
        int num;        // The randomly generated number to be guessed
        int guess;      // The user's guessed number
        int tries = 0;  // Number of attempts made by the user

        Random random = new Random();
        num = random.nextInt(100) + 1; // Generates a random number between 1 and 100

        System.out.println("***********NUMBER-GUESSING-GAME**********");

        Scanner scanner = new Scanner(System.in);

        do {
            System.out.print("Enter a guess number between (1-100): ");
            guess = scanner.nextInt(); // Get the user's input
            tries++;                   //  to Increment the number of tries

            if (guess > num) {
                System.out.println("Too High!");
            } else if (guess < num) {
                System.out.println("Too Low!");
            } else {
                System.out.println("CORRECT GUESS! Number of tries: " + tries);
            }

        } while (guess != num); // Continue the loop until the user's guess is correct

        System.out.println("*****************************");
    }
}

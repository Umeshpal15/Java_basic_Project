import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Random;

public class GuessingGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int secretNumber = random.nextInt(500) + 1; // Generate random number between 1 and 500
        int attempts = 0;

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("Guess a number between 1 and 500 (inclusive). You have 3 attempts.");

        do {
            try {
                System.out.print("Enter your guess: ");
                int guess = scanner.nextInt();
                attempts++;

                if (guess == secretNumber) {
                    System.out.printf("Congratulations! You guessed the number in %d attempts.\n", attempts);
                    break;
                } else if (guess < secretNumber) {
                    System.out.println("Your guess is too low. Try again.\n");
                } else {
                    System.out.println("Your guess is too high. Try again.\n");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.\n");
                scanner.nextLine(); // Clear the scanner buffer after invalid input
            }
        } while (attempts < 3);

        if (attempts == 3) {
            System.out.printf("Sorry, you ran out of attempts. The secret number was %d.\n", secretNumber);
        }

        scanner.close();
    }
}
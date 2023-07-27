import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int minRange = 1;
        int maxRange = 100;
        int maxAttempts = 5;
        int score = 0;

        System.out.println("Welcome to the Number Guessing Game!");

        
        boolean playAgain = true;
        while (playAgain) {
            int targetNumber = random.nextInt(maxRange - minRange + 1) + minRange;
            int attempts = 0;

            System.out.println("\nPlease choose a number between 1 and 100?");

            for (; attempts < maxAttempts; attempts++) {
                System.out.print("Attempt" + (attempts + 1) + ": Enter your guess: ");
                int userGuess = scanner.nextInt();

                if (userGuess == targetNumber) {
                    score += maxAttempts - attempts;
                    System.out.println("Congratulations! You guessed the correct number.");
                    break;
                } else if (userGuess < targetNumber) {
                    System.out.println("Too low. Try again!");
                } else {
                    System.out.println("Too high. Try again!");
                }
            }

            if (attempts == maxAttempts) {
                System.out.println("The correct number was: " + targetNumber);
            }

            System.out.print("Your current score: " + score + "\nDo you want to play again? (yes/no): ");
            String playAgainInput = scanner.next();
            playAgain = playAgainInput.equalsIgnoreCase("yes");
        }

        System.out.println("Thanks for playing the Number Game!");
        scanner.close();
    }
}
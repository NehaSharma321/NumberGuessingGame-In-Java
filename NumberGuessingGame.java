import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        int minRange = 1;
        int maxRange = 100;
        int maxAttempts = 5;
        int score = 0;
        boolean playAgain = true;
        
        while (playAgain) {
            int targetNumber = random.nextInt(maxRange - minRange + 1) + minRange;
            System.out.println("Welcome to the Number Guessing Game!");
            System.out.println("I have selected a number between " + minRange + " and " + maxRange + ".");
            System.out.println("You have " + maxAttempts + " attempts to guess it.");

            int attempts = 0;
            boolean guessedCorrectly = false;

            while (attempts < maxAttempts && !guessedCorrectly) {
                System.out.print("Enter your guess: ");
                int guess = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                attempts++;

                if (guess == targetNumber) {
                    System.out.println("Congratulations! You've guessed the correct number in " + attempts + " attempts.");
                    score++;
                    guessedCorrectly = true;
                } else if (guess < targetNumber) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }
            }

            if (!guessedCorrectly) {
                System.out.println("Sorry, you've used all your attempts. The correct number was: " + targetNumber);
            }

            System.out.println("Your current score: " + score);
            System.out.print("Would you like to play again? (yes/no): ");
            String playChoice = scanner.nextLine();
            if (!playChoice.equalsIgnoreCase("yes")) {
                playAgain = false;
            }
        }
        
        System.out.println("Thank you for playing!");
        scanner.close();
    }
}
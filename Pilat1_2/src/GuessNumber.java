import java.util.Random;
import java.util.Scanner;

public class GuessNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean playAgain = true;

        while (playAgain) {
            int targetNumber = random.nextInt(100) + 1;
            int attempts = 0;
            long startTime = System.nanoTime();

            System.out.println("Game - Guess the Number");
            System.out.println("A number from 1 to 100 has been chosen");

            while (true) {
                System.out.print("Try to guess ('q' to quit): ");
                String input = scanner.nextLine();

                if (input.equalsIgnoreCase("q")) {
                    System.out.println("Game ended. The chosen number was: " + targetNumber);
                    break;
                }

                int guess;
                try {
                    guess = Integer.parseInt(input);
                } catch (NumberFormatException e) {
                    System.out.println("You need to enter either a number or 'q' to quit.");
                    continue;
                }

                attempts++;

                if (guess < 1 || guess > 100) {
                    System.out.println("You are out of range. Enter a number between 1 and 100.");
                } else if (guess < targetNumber) {
                    System.out.println("Higher");
                } else if (guess > targetNumber) {
                    System.out.println("Lower");
                } else {
                    long endTime = System.nanoTime();
                    double durationMs = (endTime - startTime) / 1_000_000_000.0;
                    System.out.println("You guessed the chosen number " + targetNumber + " in " + attempts + " attempts.");
                    System.out.println("Time taken: " + String.format("%.2f", durationMs) + " s");
                    break;
                }
            }

            System.out.print("Play again? (y/n): ");
            String playAgainInput = scanner.nextLine();
            playAgain = playAgainInput.equalsIgnoreCase("y");
        }

        System.out.println("Game ended");
        scanner.close();
    }
}
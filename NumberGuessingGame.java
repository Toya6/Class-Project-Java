import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
// Array element to hold intergral values
    public static void main(String[] args) {
        int wins = 0;
        int losses = 0;
        int totalGamesPlayed = 0;
        final int maxGames = 5;
// Loop until the user has played the maximum number of games
        Scanner scanner = new Scanner(System.in);
// Random number generator
        while (totalGamesPlayed < maxGames) {
            System.out.println("Game " + (totalGamesPlayed + 1));
            int randomNum = generateRandomNumber(1, 10);
            int attempts = playGame(randomNum, scanner);
// Update the wins and losses counters
            if (attempts == 1) {
                wins++;
            } else {
                losses++;
            }

            totalGamesPlayed++;
        }
// Display the final results
        double winPercentage = ((double) wins / totalGamesPlayed) * 100;
        System.out.println("\nResults:");
        System.out.println("Wins: " + wins);
        System.out.println("Losses: " + losses);
        System.out.println("Win Percentage: " + winPercentage + "%");

        scanner.close();
    }
// Generate a random number between min and max
    public static int generateRandomNumber(int min, int max) {
        Random rand = new Random();
        return rand.nextInt((max - min) + 1) + min;
    }
// Play a single game
    public static int playGame(int randomNum, Scanner scanner) {
        int attempts = 0;
        boolean userWon = false;
// Loop until the user guesses the correct number
        while (!userWon) {
            System.out.print("Guess the number between 1 and 10: ");
            int userGuess = scanner.nextInt();
            attempts++;

            if (userGuess == randomNum) {
                userWon = true;
                System.out.println("Congratulations! You guessed the number in " + attempts + " attempts.");
            } else {
                System.out.println("Try again.");
            }
        }

        return attempts;
    }
}
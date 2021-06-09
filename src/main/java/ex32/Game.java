package ex32;

import java.util.Scanner;

public class Game {
    private static final Sol32 app = new Sol32();
    static final Scanner in = new Scanner(System.in);

    boolean startGame() {
        int cap = this.getDifficulty();
        int target = this.generateRandomValue(cap);
        int guessCount = this.playGame(target);
        return this.endGame(guessCount);
    }

    int verifyInput()
    {
        String input = in.nextLine();
        try {
            return Integer.parseInt(input);
        } catch (Exception e) {
            return -1;
        }
    }

    int getDifficulty() {
        int input = 0;
        while (input < 1 || input > 3){
            System.out.print("Enter the difficulty level (1, 2, or 3): ");
            input = this.verifyInput();
        }
        return (int) Math.pow(10, input);
    }

    int generateRandomValue(int cap)
    {
        int rand = (int) (Math.random() * (cap - 1)); //produces a value from 0 to (cap-1)
        rand++; // makes range 1 to cap
        return rand;
    }

    int playGame(int target)
    {
        int guess;
        int guessCount = 0;
        Boolean guessedCorrect = false;
        System.out.print("I have my number. What's your guess? ");
        while (!guessedCorrect){
            guess = this.verifyInput();
            guessCount++;
            guessedCorrect = this.guessTest(target, guess);
        }
        return guessCount;
    }

    Boolean guessTest(int target, int guess)
    {
        if (guess < 1) {
            System.out.print("Invalid guess. Guess again: ");
            return false;
        }
        else if (guess < target) {
            System.out.print("Too low. Guess again: ");
            return false;
        }
        else if(guess > target) {
            System.out.print("Too high. Guess again: ");
            return false;
        }
        else
            return true;
    }

    Boolean endGame(int guessCount)
    {
        System.out.print("You got it in " + guessCount + " guesses!\n\n");
        while(true) {
            System.out.print("Do you wish to play again (Y/N)? ");
            String input = in.nextLine();
            if (input.equals("Y") || input.equals("y"))
                return true;
            else if (input.equals("N") || input.equals("n"))
                return false;
            else
                System.out.println("Invalid input.");
        }
    }
}

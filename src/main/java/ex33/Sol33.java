/*
 *  UCF COP3330 Summer 2021 Assignment 2 Solution
 *  Copyright 2021 Douglas Glover
 */
package ex33;
import java.util.Scanner;
/*
Arrays are great for storing possible responses from a program. If you combine that with a random number generator,
you can pick a random entry from this list, which works great for games.

Create a Magic 8 Ball game that prompts for a question and then displays either "Yes," "No," "Maybe," or "Ask again later."

Example Output

What's your question?
> Will I be rich and famous?

Ask again later.

Constraint

The value should be chosen randomly using a pseudo random number generator. Store the possible choices in a list and select one at random.

Challenges

Implement this as a GUI application.
If available, use native device libraries to allow you to “shake” the 8 ball.
 */
public class Sol33 {
    private static final Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        Sol33 app = new Sol33();
        app.promptQuestion();
        String message = app.shake();
        app.response(message);
    }
    void promptQuestion()
    {
        System.out.println("What's your question?");
        in.nextLine();
    }
    String shake()
    {
        int range = (int) Math.ceil(Math.random() * 4) - 1; // returns integer from 0 to 3
        String[] responseArray = {
                "Yes.",
                "No.",
                "Maybe.",
                "Ask again later."
        };
       return responseArray[range];
    }
    void response(String message)
    {
        System.out.print("\n" + message);
    }
}

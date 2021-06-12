/*
 *  UCF COP3330 Summer 2021 Assignment 2 Solution
 *  Copyright 2021 Douglas Glover
 */
package ex37;
import java.util.Scanner;
/*
Coming up with a password that meets specific requirements is something your computer can do.
And it will give you practice using random number generators in conjunction with a list of known values.

Create a program that generates a secure password. Prompt the user for the minimum length, the number of special characters,
and the number of numbers. Then generate a password for the user using those inputs.

Example Output

What's the minimum length? 8
How many special characters? 2
How many numbers? 2
Your password is aurn2$1s#

Constraints

Use lists to store the characters you’ll use to generate the passwords.
Ensure that the generated password is random.
Ensure that there are at least as many letters are there are special characters and number.

Challenges

Randomly convert vowels to numbers, such as 3 for E and 4 for A.
Have the program present a few options rather than a single result.
Place the password on the user’s clipboard when generated.
 */
public class Sol37 {
    static final Sol37 app = new Sol37();
    static final Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        PasswordGenerator pass = new PasswordGenerator();
        int minLength = app.promptInt("What's the minimum length? ");
        int specialCount = app.promptInt("How many special characters? ");
        int numberCount = app.promptInt("How many numbers? ");
        String password = pass.generatePassword(specialCount, numberCount, minLength);
        app.output(password);
    }
    int promptInt(String prompt)
    {
        System.out.print(prompt);
        return in.nextInt();
    }
    void output(String message)
    {
        System.out.print(message);
    }
}

/*
 *  UCF COP3330 Summer 2021 Assignment 2 Solution
 *  Copyright 2021 Douglas Glover
 */
package ex24;
import java.util.Scanner;
/*
Using functions to abstract the logic away from the rest of your code makes it easier to read and easier to maintain.

Create a program that compares two strings and determines if the two strings are anagrams.
The program should prompt for both input strings and display the output as shown in the example that follows.

Example Output

Enter two strings and I'll tell you if they are anagrams:
Enter the first string: note
Enter the second string: tone
"note" and "tone" are anagrams.

Constraints

Implement the program using a function called isAnagram, which takes in two words as its arguments and returns true or false.
Invoke this function from your main program.
Check that both words are the same length.

Challenge

Complete this program without using built-in language features. Use selection or repetition logic instead and develop your own algorithm.
 */
public class Sol24 {
    private static final Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        Sol24 app = new Sol24();
        AnagramCheck anagram = new AnagramCheck();

        System.out.println("Enter two strings and I'll tell you if they are anagrams:");
        String string1 = app.promptInput("Enter the first string: ");
        String string2 = app.promptInput("Enter the second string: ");

        boolean result = anagram.isAnagram(string1, string2);
        app.output(string1, string2, result);
    }
    String promptInput(String prompt)
    {
        System.out.println(prompt);
        return in.nextLine();
    }
    void output(String string1, String string2, boolean result)
    {
        if (result)
            System.out.printf("\"%s\" and \"%s\" are anagrams.", string1, string2);
        else
            System.out.printf("\"%s\" and \"%s\" are not anagrams.", string1, string2);
    }
}

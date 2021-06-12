/*
 *  UCF COP3330 Summer 2021 Assignment 2 Solution
 *  Copyright 2021 Douglas Glover
 */
package ex38;

import java.util.Scanner;

/*
Sometimes input you collect will need to be filtered down. Data structures and loops can make this process easier.

Create a program that prompts for a list of numbers, separated by spaces. Have the program print out a new list containing only the even numbers.

Example Output

Enter a list of numbers, separated by spaces: 1 2 3 4 5 6 7 8
The even numbers are 2 4 6 8.

Constraints

Convert the input to an array.
Many languages can easily convert strings to arrays with a built-in function that splits apart a string based on a specified delimiter.
Write your own algorithm—don’t rely on the language’s built-in filter or similar enumeration feature.
Use a function called filterEvenNumbers to encapsulate the logic for this. The function takes in the old array and returns the new array.

Challenge

Instead of prompting for numbers, read in lines from any text file and print out only the even-numbered lines.
 */
public class Sol38 {
    private static final Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        Sol38 app = new Sol38();
        String input = app.getInput();
        int[] array = app.getArray(input);
        int[] evens = app.filterEvenNumbers(array);
        String message = app.makeMessage(evens);
        app.output(message);
    }
    String getInput()
    {
        System.out.print("Enter a list of numbers, separated by spaces: ");
        return in.nextLine();
    }
    int[] getArray(String input)
    {
        String[] splitValues = input.split(" ");
        int[] array = new int[splitValues.length];
        for(int i = 0; i < splitValues.length; i++)
        {
            array[i] = Integer.parseInt(splitValues[i]);
        }
        return array;
    }
    int[] filterEvenNumbers(int[] array)
    {
        int evenCount = 0;
        for (int value : array)
            if (value % 2 == 0)
                evenCount++;
        int[] evens = new int[evenCount];
        int index = 0;
        for (int value : array) {
            if (value % 2 == 0) {
                evens[index] = value;
                index++;
            }
        }
        return evens;
    }
    String makeMessage(int[] array)
    {
        String message = "The even numbers are";
        for(int value : array)
        {
            message += " " + value;
        }
        message += ".";
        return message;
    }
    void output(String message)
    {
        System.out.print(message);
    }
}


/*
 *  UCF COP3330 Summer 2021 Assignment 2 Solution
 *  Copyright 2021 Douglas Glover
 */
package ex36;
import java.util.ArrayList;
import java.util.Scanner;
/*
Statistics is important in our field. When measuring response times or rendering times, it’s helpful to collect data so you can easily spot abnormalities.
For example, the standard deviation helps you determine which values are outliers and which values are within normal ranges.

Write a program that prompts for response times from a website in milliseconds. It should keep asking for values until the user enters “done.”

The program should print the average time (mean), the minimum time, the maximum time, and the population standard deviation.

Example Output

Enter a number: 100
Enter a number: 200
Enter a number: 1000
Enter a number: 300
Enter a number: done
Numbers: 100, 200, 1000, 300
The average is 400.0
The minimum is 100
The maximum is 1000
The standard deviation is 353.55

Constraints

Use functions called average, max, min, and std, which take in a list of numbers and return the results.
Use loops and arrays to perform the input and mathematical operations.
Be sure to exclude the "done" entry from the inputs.
Be sure to properly ignore any invalid inputs.
Keep the input separate from the processing and the output.

Challenges

Have the program read in numbers from an external file instead of prompting for the values.
 */
public class Sol36 {
    static final Sol36 app = new Sol36();
    private static final Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();
        app.getNumbers(numbers);
        app.listNumbers(numbers);
        app.listStats(numbers);
    }
    void getNumbers(ArrayList<Integer> numbers)
    {
        String input;
        int value;

        while(true) {
            System.out.print("Enter a number: ");
            input = in.nextLine();
            if (input.equals("done"))
                break;
            try {
                value = Integer.parseInt(input);
            }
            catch(Exception e) {
                System.out.println("Invalid input.");
                continue;
            }
            numbers.add(value);
        }
    }
    void listNumbers(ArrayList<Integer> numbers)
    {
        String message = "Numbers: ";
        int size = numbers.size();
        int value;
        for(int i = 0; i < size - 1; i++) {
            message += numbers.get(i) + ", ";
        }
        message += numbers.get(size - 1);
        System.out.println(message);
    }
    void listStats(ArrayList<Integer> numbers)
    {
        Statistics stats = new Statistics();
        double average = stats.average(numbers);
        int min = stats.min(numbers);
        int max = stats.max(numbers);
        double std = stats.std(numbers);
        System.out.printf("""
        The average is %.1f
        The minimum is %d
        The maximum is %d
        The standard deviation is %.2f
        """, average, min, max , std);
    }
}

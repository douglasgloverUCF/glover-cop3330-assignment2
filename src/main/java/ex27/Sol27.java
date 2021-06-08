/*
 *  UCF COP3330 Summer 2021 Assignment 2 Solution
 *  Copyright 2021 Douglas Glover
 */
package ex27;
import java.util.Scanner;
/*
Large functions aren't very usable or maintainable. It makes a lot of sense to break down the logic of a program into smaller functions
that do one thing each. The program can then call these functions in sequence to perform the work.

Write a program that prompts for a first name, last name, employee ID, and ZIP code. Ensure that the input is valid according to these rules:

The first name must be filled in.
The last name must be filled in.
The first and last names must be at least two characters long.
An employee ID is in the format AA-1234. So, two letters, a hyphen, and four numbers.
The ZIP code must be a number.
Display appropriate error messages on incorrect data.

Example Output

Enter the first name: J
Enter the last name:
Enter the ZIP code: ABCDE
Enter an employee ID: A12-1234
"J" is not a valid first name. It is too short.
The last name must be filled in.
The ZIP code must be numeric.
A12-1234 is not a valid ID.

Or

Enter the first name: Jimmy
Enter the last name: James
Enter the ZIP code: 55555
Enter an employee ID: TK-421
There were no errors found.

Constraints

Create a function for each type of validation you need to write. Then create a validateInput function that takes in all of the input data
and invokes the specific validation functions.
Use a single output statement to display the outputs.

Challenges

Use regular expressions to validate the input.
Implement this as a GUI application or web application that gives immediate feedback when the fields lose focus.
Repeat the process if the input is not valid.
 */
public class Sol27 {
    private static final Scanner in = new Scanner(System.in);
    private static final Sol27 app = new Sol27();
    public static void main(String[] args) {

        String fName = app.promptString("Enter the first name: ");
        String lName = app.promptString("Enter the last name: ");
        String zip = app.promptString("Enter the ZIP code: ");
        String id = app.promptString("Enter an employee ID: ");
        String errors = app.validateInput(fName, lName, zip, id);
        app.output(errors);
    }
    String promptString(String prompt)
    {
        System.out.print(prompt);
        return in.nextLine();
    }
    String validateInput(String fName, String lName, String zip, String id)
    {
        String errors = "";
        errors = errors + app.validateFName(fName);
        errors = errors + app.validateLName(lName);
        errors = errors + app.validateZip(zip);
        errors = errors + app.validateId(id);
        if (errors.equals(""))
            errors = "There were no errors found.";
        return errors;
    }
    String validateFName(String input)
    {
        if(input.isBlank())
            return "The first name must be filled in.\n";
        else if (input.length() < 2)
            return "\"" + input + "\" is not a valid first name. It is too short.\n";
        return "";
    }
    String validateLName(String input)
    {
        if(input.isBlank())
            return "The last name must be filled in.\n";
        else if (input.length() < 2)
            return "\"" + input + "\" is not a valid last name. It is too short.\n";
        return "";
    }
    String validateZip(String input)
    {
        try {
            Integer.parseInt(input);
            return "";
        }
        catch(Exception e) {
            return "The ZIP code must be numeric.\n";
        }
    }
    String validateId(String input)
    {
        char c;
        String fail = input + " is not a valid ID.\n";

        c = input.charAt(0);
        if (!Character.isLetter(c))
            return fail;

        c = input.charAt(1);
        if (!Character.isLetter(c))
            return fail;

        c = input.charAt(2);
        if (c != '-')
            return fail;

        String end = input.substring(3);
        try {
            Integer.parseInt(end);
            return "";
        }
        catch(Exception e) {
            return fail;
        }
    }
    void output(String message)
    {
        System.out.print(message);
    }
}

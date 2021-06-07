/*
 *  UCF COP3330 Summer 2021 Assignment 2 Solution
 *  Copyright 2021 Douglas Glover
 */
package ex25;
import java.util.Scanner;
/*
Functions help you abstract away complex operations, but they also help you build reusable components.

Create a program that determines the complexity of a given password based on these rules:

A very weak password contains only numbers and is fewer than eight characters.
A weak password contains only letters and is fewer than eight characters.
A strong password contains letters and at least one number and is at least eight characters.
A very strong password contains letters, numbers, and special characters and is at least eight characters.

Example Output

The password '12345' is a very weak password.
The password 'abcdef' is a weak password.
The password 'abc123xyz' is a strong password.
The password '1337h@xor!' is a very strong password.

Constraints

Create a passwordValidator function that takes in the password as its argument and returns a value you can evaluate to determine the password strength.
Do not have the function return a string—you may need to support multiple languages in the future.
Use a single output statement.

Challenge

Create a GUI application or web application that displays graphical feedback as well as text feedback in real time.
As someone enters a password, determine its strength and display the result
 */
public class Sol25 {
    private static final Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        Sol25 app = new Sol25();
        String password = app.getPassword();
        int strength = app.passwordValidator(password);
        app.outputStrength(strength, password);
    }
    String getPassword()
    {
        System.out.print("Enter a password: ");
        return in.nextLine();
    }
    int passwordValidator(String password)
    {
        int strength = -1;
        int length = password.length();

        int numberCount = 0;
        int letterCount = 0;
        int specialCount = 0;

        char c;

        for(int i = 0; i < length; i++)
        {
            c = password.charAt(i);
            if (c >= 48 && c <= 57) numberCount++; // range of numbers
            else if ((c >= 65 && c <= 90) || (c >= 97 && c <= 122)) letterCount++; // range of letters
            else specialCount++;
        }

        if(numberCount == length && length < 8) strength = 0;
        if(letterCount == length && length < 8) strength = 1;
        if(letterCount > 0 && numberCount > 0 && length > 8) strength = 2;
        if(specialCount > 0 && letterCount > 0 && numberCount > 0 && length > 8) strength = 3;

        return strength;
    }
    void outputStrength(int strength, String password)
    {
        String message;
        switch (strength) {
            case 0 -> message = "The password '" + password + "' is a very weak password.";
            case 1 -> message = "The password '" + password + "' is a weak password.";
            case 2 -> message = "The password '" + password + "' is a strong password.";
            case 3 -> message = "The password '" + password + "' is a very strong password.";
            default -> message = "I don't know how strong '" + password + "' is.";
        }
        System.out.print(message);
    }
}

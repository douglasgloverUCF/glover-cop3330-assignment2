/*
 *  UCF COP3330 Summer 2021 Assignment 2 Solution
 *  Copyright 2021 Douglas Glover
 */
package ex26;
import java.util.Scanner;
/*
It can take a lot longer to pay off your credit card balance than you might realize. And the formula for figuring that out isn’t pretty.
Hiding the formula’s complexity with a function can help you keep your code organized.

Write a program that will help you determine how many months it will take to pay off a credit card balance.
The program should ask the user to enter the balance of a credit card, the APR of the card, and their monthly payment.
The program should then return the number of months needed (rounded up to the next integer value).

The formula for this is

n = -(1/30) * log(1 + b/p * (1 - (1 + i)^30)) / log(1 + i)
where

n is the number of months.
i is the daily rate (APR divided by 365).
b is the balance.
p is the monthly payment.

Example Output

What is your balance? 5000
What is the APR on the card (as a percent)? 12
What is the monthly payment you can make? 100
It will take you 70 months to pay off this card.

Constraints

Prompt for the card’s APR. Do the division internally.
Prompt for the APR as a percentage, not a decimal.
Use a function called calculateMonthsUntilPaidOff, which accepts the balance, the APR, and the monthly payment as its arguments
and returns the number of months. Don’t access any of these values outside the function.
Round fractions of a cent up to the next cent.

Challenge

Rework the formula so the program can accept the number of months as an input and compute the monthly payment.
Create a version of the program that lets the user choose whether to figure out the number of months until payoff or the amount needed to pay per month.
 */
public class Sol26 {
    private static final Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        Sol26 app = new Sol26();
        double balance = app.promptDouble("What is your balance? ");
        double apr = app.promptDouble("What is the APR on the card (as a percent)? ");
        double payment = app.promptDouble("What is the monthly payment you can make? ");
        int months = app.calculateMonthsUntilPaidOff(balance, apr, payment);
        app.output(months);
    }
    double promptDouble(String prompt)
    {
        System.out.print(prompt);
        double value = in.nextDouble();
        return Math.round(value * 100f)/100f;
    }
    int calculateMonthsUntilPaidOff(double balance, double apr, double payment)
    {
        double dailyRate = apr / 100f / 365f;
        double months = -(1f/30f) * Math.log(1 + balance / payment * (1f - Math.pow((1f + dailyRate), 30f))) / Math.log(1 + dailyRate);
        return (int) Math.ceil(months);
    }
    void output(int months)
    {
        System.out.printf("It will take you %d months to pay off this card.", months);
    }
}

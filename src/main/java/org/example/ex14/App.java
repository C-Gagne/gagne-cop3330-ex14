/*
 *  UCF COP3330 Summer 2021 Assignment 1 Solutions
 *  Copyright 2021 Crystal Gagne
 */

package org.example.ex14;

import java.util.Scanner;

public class App {
    Scanner in = new Scanner(System.in);

    public static void main(String[] args)
    {
        App mainApp = new App();

        double amount = mainApp.getAmount();
        String state = mainApp.getState();

        double tax = 0.00;

        if (state.equalsIgnoreCase("WI") || state.equalsIgnoreCase("Wisconsin"))
        {
            tax = mainApp.getTax(amount);
        }

        double total = tax + amount;

        String outputString = genOutputString(state, amount, tax, total);
        System.out.println(outputString);
    }

    public Double getAmount()
    {
        System.out.println("What is the amount?");
        double userAmount = in.nextDouble();
        in.nextLine(); // Program does not go to the next line from the double, so getState() fails to ask for an input without this line.
        return userAmount;
    }

    public String getState()
    {
        System.out.println("What is the state?");
        return in.nextLine();
    }

    public Double getTax(double amount)
    {
        double taxRate = 0.0550;

        return (taxRate * amount);
    }

    public static String genOutputString(String state, double amount, double tax, double total)
    {
        if (state.equalsIgnoreCase("WI") || state.equalsIgnoreCase("Wisconsin"))
        {
            return String.format("The subtotal is $%.2f\nThe tax is $%.2f.\nThe total is $%.2f.", amount, tax, total);
        }
        return String.format("The total is $%.2f.", amount);
    }
}

/*
 *  UCF COP3330 Summer 2021 Assignment 1 Solution
 *  Copyright 2021 Mauricio Rios
 */
package ex20;

import java.util.Scanner;

public class App {
    Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        App myApp = new App();
        double amount = myApp.getAmount();
        String state = myApp.getState();
        String county = myApp.getCounty();
        double tax = myApp.getTax(state, county, amount);
        double total = myApp.getTotal(amount, tax);
        String outputString = myApp.generateOutputString(tax, total);
        myApp.printOutput(outputString);
    }

    public double getAmount() {
        System.out.print("What is the order amount? ");
        double amount = in.nextDouble();
        in.nextLine();
        return amount;
    }

    public String getState() {
        System.out.print("What state do you live in? ");
        return in.nextLine();
    }

    public String getCounty() {
        System.out.print("What county do you live in? ");
        return in.nextLine();

    }

    public double getTax(String state, String county, double amount) {
        double tax = 0.00;
        if(state.equalsIgnoreCase("Wisconsin")) {
            if(county.equalsIgnoreCase("Eau Claire")) {
                tax = amount * 0.055;
                return Math.round(tax*100d)/100.0;
            }
            else if(county.equalsIgnoreCase("Dunn")) {
                tax = amount * 0.054;
                return Math.round(tax * 100d) / 100.0;
            }
            else {
                tax = amount * 0.050;
                return Math.round(tax * 100d) / 100.0;
            }
        }
        else if(state.equalsIgnoreCase("Illinois")) {
            tax = amount *0.08;
            return Math.round(tax*100d)/100.0;
        } else {
            return tax;
        }
    }

    public double getTotal(double amount, double tax) {
        return amount + tax;
    }

    public String generateOutputString(Double tax, Double total) {
        return "The tax is $"+tax+".\nThe total is $"+total+".";
    }

    public void printOutput(String outputString) {
        System.out.print(outputString);
    }
}
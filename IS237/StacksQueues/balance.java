package StacksQueues;

import java.util.Scanner;

public class balance {
    public static void main(String[] args) {
        Scanner ingiza = new Scanner(System.in);
        System.out.printf("\n***BALANCED BLACKETS***\n\n");
        System.out.print("Enter your string here: ");
        String myString = ingiza.nextLine();
        if (balancedBrackets(myString)) {
            System.out.println("Your String is perfect");
        } else
            System.out.println("Your string has UNBALANCED BRACKETS");
        ingiza.close();
    }

    public static boolean balancedBrackets(String myString) {
        Stack myStack = new Stack(myString.length());
        char openingBracket = '(';
        char closingBracket = ')';

        for (int index = 0; index < myString.length(); index++) {
            if (myString.charAt(index) == openingBracket) {
                myStack.push(openingBracket);
            }
            if (myString.charAt(index) == closingBracket) {
                if (!myStack.isEmpty()) {
                    myStack.pop();
                } else {
                    return false;
                }
            }
        }
        if (!myStack.isEmpty()) {
            return false;
        } else
            return true;
    }
}
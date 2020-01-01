package StacksQueues;

import java.util.Scanner;

public class Palindrome {
    public static void main(String[] args) {
        Scanner ingiza = new Scanner(System.in);
        System.out.println("***PALINDROME***");
        System.out.printf("\n\nEnter your string here:");
        String myString = ingiza.nextLine();
        if (isPalindrome(myString)) {
            System.out.printf("\nYour String is PALINDROME\n");
        } else
            System.out.printf("\nYour String is NOT PALINDROME\n");
        ingiza.close();
    }

    public static boolean isPalindrome(String myString) {
        Stack myStack = new Stack(myString.length());
        CharQueue myCharQueue = new CharQueue(myString.length());

        for (int index = 0; index < myString.length(); index++) {
            char c = myString.charAt(index);
            myStack.push(c);
            myCharQueue.enqueue(c);
        }

        for (int index = 0; index < myString.length(); index++) {
            char val1 = myStack.pop();
            char val2 = myCharQueue.dequeue();
            if (val1 != val2) {
                return false;
            }
        }
        return true;
    }

    public static boolean isParlindrome(String myString) {
        for (int i = 0; i < myString.length(); i++) {
            char val1 = myString.charAt(i);
            char val2 = myString.charAt(myString.length() - (i + 1));
            if (val1 != val2)
                return false;
        }
        return true;
    }
}
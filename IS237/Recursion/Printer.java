package Recursion;

import java.util.Scanner;

public class Printer {
    public static void main(String[] args) {
        Scanner ingiza = new Scanner(System.in);
        System.out.print("Enter the message you want to print: ");
        String message = ingiza.nextLine();
        System.out.print("How many times do you want to print the message: ");
        int numb = ingiza.nextInt();
        iterativePrinter(message, numb);
        ingiza.close();
    }

    public static void iterativePrinter(String message, int numb) {
        for (int i = 0; i < numb; i++)
            System.out.println(message);
    }
}
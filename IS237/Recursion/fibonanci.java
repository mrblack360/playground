package Recursion;

import java.util.Scanner;

public class fibonanci {
    public static void main(final String[] args) {
        Scanner ingiza = new Scanner(System.in);
        System.out.printf("\n***FIBONANCI SERIES***\n\n");
        System.out.printf("Enter the index of the number in the series:");
        int index = ingiza.nextInt();
        System.out.printf("\nThe %dth element in the FIBONANCI SERIES is %d\n", index, fibonanciNumber(index));
        ingiza.close();
    }

    public static int fibonanciNumber(final int count) {
        int first = 0, second = 1, third = 0;

        for (int index = 2; index < count; index++) {
            third = second + first;
            first = second;
            second = third;
        }
        return third;
    }
}
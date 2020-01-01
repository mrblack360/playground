package Recursion;

import java.util.Scanner;

public class Zero {
    public static void main(String[] args) {
        Scanner ingiza = new Scanner(System.in);
        System.out.printf("***NUMBER OF ZEROS***");
        System.out.printf("\nEnter the number: ");
        int numb = ingiza.nextInt();
        System.out.printf("\nNumber of zeros in %d is %d\n", numb, iterativeZeros(numb));
        ingiza.close();
    }

    public static int zeros(int numb) {
        if (numb == 0)
            return 1;
        else if (numb < 10 && numb > -10)
            return 0;
        else
            return zeros(numb / 10) + zeros(numb % 10);
    }

    public static int iterativeZeros(int numb) {
        int zerosCount = 0;
        while (numb > 9 || numb < -9) {
            if (numb % 10 == 0) {
                zerosCount = zerosCount + 1;
            }
            numb = numb / 10;
        }
        return zerosCount;
    }
}
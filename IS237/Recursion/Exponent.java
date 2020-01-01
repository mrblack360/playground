package Recursion;

import java.util.Scanner;

public class Exponent {
    public static void main(String[] args) {
        Scanner ingiza = new Scanner(System.in);
        System.out.printf("Enter the base and exponent respectively:");
        int numb = ingiza.nextInt();
        int power = ingiza.nextInt();
        System.out.printf("%d ^ %d = %d = %d\n", numb, power, exp(numb, power), iterativeExp(numb, power));
        ingiza.close();
    }

    public static int exp(int numb, int power) {
        if (power == 0)
            return 1;
        return numb * exp(numb, power - 1);
    }

    public static int iterativeExp(int numb, int power) {
        int answer = 1;
        for (int i = 0; i < power; i++) {
            answer = answer * numb;
        }
        return answer;
    }
}
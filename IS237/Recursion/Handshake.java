package Recursion;

import java.util.Scanner;

public class Handshake {
    public static void main(String[] args) {
        Scanner ingiza = new Scanner(System.in);
        System.out.printf("***HANDSHAKE***\n");
        System.out.printf("Enter the number of people: ");
        int peopleCount = ingiza.nextInt();
        System.out.printf("Recursive evaluation is: %d\tIterative evaluation is: %d\n", recursiveHandshake(peopleCount),
                iterativeHandshake(peopleCount));
        ingiza.close();
    }

    public static int recursiveHandshake(int peopleCount) {
        if (peopleCount == 1) {
            return 0;
        }
        if (peopleCount == 2) {
            return 1;
        } else
            return recursiveHandshake(peopleCount - 1) + (peopleCount - 1);

    }

    public static int iterativeHandshake(int peopleCount) {
        int temp = 0;
        int handshakes = 0;
        for (int i = 0; i < peopleCount; i++) {
            handshakes = temp + i;
            temp = handshakes;
        }
        return handshakes;
    }
}
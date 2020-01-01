package Recursion;

import java.util.Scanner;

public class hanoi {

    public static void main(String[] args) {
        Scanner ingiza = new Scanner(System.in);
        System.out.println("SOLVE TOWER OF HANOI EASILY");
        System.out.printf("\n\nEnter the number of disks: ");
        int num = ingiza.nextInt();
        Hanoi(num, "a", "c", "b");
        System.out.printf("\n\nOptimal nomber of moves is: %d\n", movesCounter(num));
        ingiza.close();
    }

    public static void Hanoi(int num, String frompeg, String topeg, String auxpeg) {
        if (num == 1) {
            System.out.println("Move disk 1 form needle " + frompeg + " to needle " + topeg);
        } else {
            Hanoi(num - 1, frompeg, auxpeg, topeg);
            System.out.println("Move disk " + num + " from needle " + frompeg + " to needle " + topeg);
            Hanoi(num - 1, auxpeg, topeg, frompeg);
        }
    }

    public static int movesCounter(int disks) {
        if (disks == 1)
            return 1;
        else {
            return 1 + (2 * movesCounter(disks - 1));
        }
    }
}
package Recursion;

public class recursion {
    public static void main(String[] args) {
        System.out.printf("The factorial of 3 is:%d \n", fac(3));
    }

    public static int fac(int number) {
        if (number <= 1)
            return 1;
        else
            return number * fac(number - 1);
    }
}
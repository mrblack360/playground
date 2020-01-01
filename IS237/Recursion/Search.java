package Recursion;

public class Search {
    public static void main(String[] args) {
        int[] values = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        int value = 5;

        System.out.printf("%d is located at index %d\n", value, sequentialSearch(values, value));
    }

    public static int sequentialSearch(int[] values, int value) {
        for (int i = 0; i < values.length; i++) {
            if (values[i] == value)
                return i;
        }
        return -1;
    }
}
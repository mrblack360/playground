package Recursion;

public class Factorial {
    public static void main(String[] args) {
        System.out.println(iterativeFactorial(3));
    }

    public static int iterativeFactorial(int numb) {
        int answer = 1;
        if (numb <= 0) {
            return answer;
        } else {
            for (int i = 1; i <= numb; i++) {
                answer = answer * i;
            }
            return answer;
        }
    }
}
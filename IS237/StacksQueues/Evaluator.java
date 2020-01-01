package StacksQueues;

import java.util.Scanner;

public class Evaluator {
    public static void main(String[] args) {
        System.out.printf("\n***POSTFIX EVALUATOR***\n\n");
        int answer = postfixEvaluator();

        System.out.println("The answer is:" + answer);
    }

    public static int postfixEvaluator() {
        Scanner ingiza = new Scanner(System.in);
        System.out.print("Enter the Postfix Expression: ");
        String postfixExpression = ingiza.nextLine();
        StackInt myStack = new StackInt(postfixExpression.length());
        for (int i = 0; i < postfixExpression.length(); i++) {
            char c = postfixExpression.charAt(i);

            if (Character.isDigit(c))
                myStack.push(c - '0');

            else {
                int val1 = myStack.pop();
                int val2 = myStack.pop();

                switch (c) {
                case '+':
                    myStack.push(val2 + val1);
                    break;

                case '-':
                    myStack.push(val2 - val1);
                    break;

                case '/':
                    myStack.push(val2 / val1);
                    break;

                case '*':
                    myStack.push(val2 * val1);
                    break;
                }
            }
        }
        ingiza.close();
        return myStack.pop();
    }
}
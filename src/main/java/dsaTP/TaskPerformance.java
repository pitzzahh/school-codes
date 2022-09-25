package dsaTP;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.stream.IntStream;

public class TaskPerformance {
    public static void main(String[] args) {
        System.out.println("FIRST QUESTION");
        numberOneQuestion();
        System.out.println("SECOND QUESTION");
        numberTwoQuestion();
    }

    /**
     * Computes the fibonacci sequence.
     * @param number the number of fibonacci sequence to be calculated.
     * @return the fibonacci sequence at a specific calculation.
     * This algorithm is slow.
     */
    private static int fib(int number) {
        if(number <= 1) return number;
        return fib(number - 1) + fib(number - 2);
    }

    /**
     * The solution for the first question.
     */
    private static void numberOneQuestion() {
        System.out.print("Enter a number higher than 0: ");
        int number = new Scanner(System.in).nextInt();
        /*
            Same as shown below
                for (int i = 0; i < number; i++) {
                    System.out.println(fib(i));
                }
         */
        IntStream.range(0, number)
                .map(TaskPerformance::fib)
                .forEach(System.out::println);
    }

    /**
     * The solution for the second question.
     */
    private static void numberTwoQuestion() {
        LinkedList<String> iceCreamFlavors = new LinkedList<>() {
            {
                add("Chocolate");
                add("Strawberry");
                add("Mango");
                add("Cookies and Cream");
                add("Vanilla");
            }
        };

        /*
            Same as shown below:
                for (String iceCreamFlavor : iceCreamFlavors) {
                    System.out.println(iceCreamFlavor);
                }
         */
        iceCreamFlavors.forEach(System.out::println);
    }
}

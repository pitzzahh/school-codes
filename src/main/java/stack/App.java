package stack;

import java.util.Stack;

public class App {
    private final static Stack<Integer> stack = new Stack<>();
    private static int count = 0;

    public static void main(String[] args) {
        var token = "64+93-*";
        evaluate(token);
        System.out.println(stack);
    }

    static void evaluate(String token) {
        String trimmed = token.trim();
        if (count == trimmed.length()) return;
        if (!stack.isEmpty()) System.out.println(stack);
        if (isNumber(String.valueOf(trimmed.charAt(count)))) {
            stack.push(Integer.parseInt(String.valueOf(trimmed.charAt(count))));
            count++;
            evaluate(trimmed);
        }
        else if (isOperator(String.valueOf(trimmed.charAt(count)))) {
            int a = stack.pop(); // 4
            int b = stack.pop(); // 6
            int result = 0;
            switch (trimmed.charAt(count)) {
                case '+' -> result = a + b;
                case '-' -> result = a - b;
                case '*' -> result = a * b;
                case '/' -> result = a / b;
            }
            stack.push(result);
            count++;
            evaluate(trimmed);
        }
    }

    private static boolean isOperator(String valueOf) {
        return valueOf.equals("+") || valueOf.equals("-") || valueOf.equals("*") || valueOf.equals("/");
    }

    // create a method that takes a string and checks if it is a number using regex
    // if it is a number, return true
    // if it is not a number, return false
    static boolean isNumber(String token) {
        return token.matches("\\d+");
    }

}

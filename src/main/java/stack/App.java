package stack;

import static io.github.pitzzahh.util.utilities.Print.println;
import static io.github.pitzzahh.util.utilities.Print.print;
import static java.lang.Integer.parseInt;
import static java.lang.String.valueOf;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Arrays;
import java.util.function.BiPredicate;
import java.util.function.Predicate;
import java.util.Stack;

public class App {

    private final static Stack<Character> operatorsStack = new Stack<>();
    private final static Stack<Character> postfix = new Stack<>();
    private final static Stack<Integer> stack = new Stack<>();
    private static int count = 0;

    public static void main(String[] args) {
        var postfix = "342*+9-";
        postfixEvaluation(postfix);
        println(stack);
    }

    private static void postfixEvaluation(String token) {
        var trimmed = token.trim();
        if (count == trimmed.length()) return;
        if (!stack.isEmpty()) println(stack);
        if (isNumber.test(valueOf(trimmed.charAt(count)))) {
            stack.push(parseInt(valueOf(trimmed.charAt(count))));
            count++;
        }
        else if (isOperator.test(valueOf(trimmed.charAt(count)))) {
            var a = stack.pop();
            var b = stack.pop();
            var result = 0;
            switch (trimmed.charAt(count)) {
                case '+' -> result = b + a;
                case '-' -> result = b - a;
                case '*' -> result = b * a;
                case '/' -> result = b / a;
            }
            stack.push(result);
            count++;
        }
        postfixEvaluation(trimmed);
    }

    // TODO: fix implementation
    private static void infixToPostfix(String token) {
        var trimmed = token.trim();
        if(count == trimmed.length()) return;
        //if (!postfix.isEmpty()) println(postfix);
        if (!operatorsStack.isEmpty()) println(operatorsStack);
        if (isNumber.test(valueOf(trimmed.charAt(count)))) {
            postfix.push(trimmed.charAt(count));
            count++;
            infixToPostfix(trimmed);
        }
        else if (isOperator.test(valueOf(trimmed.charAt(count)))) {
            if (!operatorsStack.isEmpty()) {
                var top = operatorsStack.peek();
                if (check.test(valueOf(trimmed.charAt(count)), valueOf(top))) {
                    postfix.push(operatorsStack.pop());
                    operatorsStack.push(trimmed.charAt(count));
                    count++;
                    infixToPostfix(trimmed);
                }
            }
            if (isClosingParenthesis.test(valueOf(trimmed.charAt(count)))) {
                operatorsStack.pop();
                var popped = postfix.pop();
                postfix.push(popped);
                count++;
                infixToPostfix(trimmed);
            }
            operatorsStack.push(trimmed.charAt(count));
            count++;
            infixToPostfix(trimmed);
        }
    }

    private static final Predicate<String> isOperator = op -> op.equals("+") || op.equals("-") || op.equals("*") || op.equals("/") || op.equals("(") || op.equals(")u");

    // create a method that takes a string and checks if it is a number using regex
    // if it is a number, return true
    // if it is not a number, return false
    private static final Predicate<String> isNumber = token -> token.matches("\\d+");

    private static final Predicate<String> isClosingParenthesis = token -> token.equals(")");

    private static final BiPredicate<String, String> check = App::isWithHighPrecedence;

    private static boolean isWithHighPrecedence(String token, String topItem) {
        var high = new String[]{"(", ")"};
        var mid = new String[]{"*/"};
        var low = new String[]{"+-"};

        var isBeforeMid = Arrays.stream(mid).anyMatch(token::equalsIgnoreCase);
        var isBeforeLow = Arrays.stream(low).anyMatch(token::equalsIgnoreCase);

        var isAfterHigher = Arrays.stream(high).anyMatch(topItem::equalsIgnoreCase);
        var isAfterMid = Arrays.stream(mid).anyMatch(topItem::equalsIgnoreCase);


        return isAfterHigher && (isBeforeMid || isBeforeLow) ||
                isAfterMid && isBeforeLow;

    }
}

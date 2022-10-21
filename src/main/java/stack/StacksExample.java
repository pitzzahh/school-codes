package stack;
import java.util.Stack;
public class StacksExample {
    public static void main(String[] args) {
        Stack secondStack = new Stack();
        secondStack.push("1"); // push String 1 to the top of the stack
        secondStack.push(2); // push integer 2 to the top of the stack
        System.out.println(secondStack); // Output: [1, 2]

        Stack<Object> firstStack = new Stack<>();
        firstStack.push("1"); // push String 1 to the top of the stack
        firstStack.push(2); // push integer 2 to the top of the stack
        System.out.println(firstStack); // Output: [1, 2]
    }
}

package midtermTP;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.Queue;
import java.util.Stack;

public class Application {

    public static void main(String[] args) {

        Stack<String> bookTitles = new Stack<>();
        Queue<String> queue = new LinkedList<>();

        System.out.println("Enter four book titles.");
        insertBooks(bookTitles, new Scanner(System.in));
        System.out.println("New order of books:");
        reverseBooks(bookTitles, queue);
        System.out.println(queue);
    }

    /**
     * Inserts books into the stack.
     * @param bookTitles stack of books
     * @param scanner scanner to read input
     */
    private static void insertBooks(Stack<String> bookTitles, Scanner scanner) {
        if (bookTitles.size() != 4) {
            System.out.printf("Book %d: ", bookTitles.size() + 1);
            bookTitles.push(scanner.nextLine());
            insertBooks(bookTitles, scanner);
        }
    }

    /**
     * Pop each element in the stack and adds them to the queue.
     * @param bookTitles Stack of book titles.
     * @param queue Queue of book titles.
     */
    private static void reverseBooks(Stack<String> bookTitles, Queue<String> queue) {
        if (!bookTitles.isEmpty()) {
            queue.add(bookTitles.pop());
            reverseBooks(bookTitles, queue);
        }
    }
}

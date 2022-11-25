package sayHi;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Greeting {
    private static final int  NUMBER_OF_NICKNAMES = 4;
    public static void main(String[] args) {
        PriorityQueue<String> priorityQueue = new PriorityQueue<>();
        Scanner scanner = new Scanner(System.in);
        addNickNames(priorityQueue, scanner);
        sayHi(priorityQueue, scanner);
        System.out.println("Done Saying Hi");
    }

    private static void addNickNames(PriorityQueue<String> priorityQueue, Scanner scanner) {
        int size = (priorityQueue.size() + 1);
        if (size <= NUMBER_OF_NICKNAMES) {
            System.out.printf("Enter the nicknames of %d of %d: ", size, NUMBER_OF_NICKNAMES);
            priorityQueue.add(scanner.nextLine());
            addNickNames(priorityQueue, scanner);
        }
    }

    private static void sayHi(PriorityQueue<String> priorityQueue, Scanner scanner) {
        if (!priorityQueue.isEmpty()) {
            System.out.print("Press H to say Hi to each of them: ");
            if (scanner.nextLine().equalsIgnoreCase("H")) System.out.println("Hi " + priorityQueue.poll());
            else System.out.println("You didn't press H");
            sayHi(priorityQueue, scanner);
        }
    }
}

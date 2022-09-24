package concurrency;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main implements Runnable {

    private static final Main MAIN = new Main();
    private static final Thread FIRST_THREAD = new Thread(MAIN);
    private static final Thread SECOND_THREAD = new Thread(MAIN);

    public static void main(String[] args) throws InterruptedException {

        setThreadNames(new Scanner(System.in));

        showThreadState();

        System.out.println();

        System.out.print("Starting the threads");
        printDots();

        FIRST_THREAD.start();
        FIRST_THREAD.join();

        SECOND_THREAD.start();

        FIRST_THREAD.join();
        SECOND_THREAD.join();

        System.out.println();

        System.out.print("After sleep");
        printDots();

        showThreadState();

    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " is " + Thread.currentThread().getState());
        try {
            Thread.sleep(1500);
        } catch (InterruptedException ignore) {}
    }

    /**
     * Method that asks for user input to set names for the thread
     * @param scanner the scanner object needed for user input.
     */
    private static void setThreadNames(Scanner scanner) {
        System.out.print("Name your first thread : ");
        FIRST_THREAD.setName(scanner.nextLine().trim());
        System.out.print("Name your second thread: ");
        SECOND_THREAD.setName(scanner.nextLine().trim());
    }

    /**
     * Method that prints the state of the threads.
     */
    private static void showThreadState() {
        System.out.println(FIRST_THREAD.getName() + " is " + FIRST_THREAD.getState());
        System.out.println(SECOND_THREAD.getName() + " is " + SECOND_THREAD.getState());
    }

    /**
     * Method that print dots after a text.
     */
    private static void printDots() {
        try {
            for (int i = 1; i <= 3; i++) {
                System.out.print(".");
                TimeUnit.MILLISECONDS.sleep(500);
            }
            System.out.println();
        } catch (InterruptedException ignored) {}
    }
}

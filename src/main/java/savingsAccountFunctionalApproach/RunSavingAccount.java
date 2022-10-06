package savingsAccountFunctionalApproach;

import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import static io.github.pitzzahh.utilities.Print.*;
import static java.lang.String.format;
import static java.lang.String.valueOf;
import static java.lang.Double.parseDouble;
import static java.util.Currency.getInstance;
import static savingsAccountFunctionalApproach.Color.*;
import static savingsAccountFunctionalApproach.SavingsAccount.showBalance;
import static savingsAccountFunctionalApproach.SavingsAccount.setInterestRate;

/**
 * Class that contains the process and running the savings account program.
 * JDK version: 17 LTS
 */
public class RunSavingAccount {

    private static final Scanner SCANNER = new Scanner(System.in);

    /**
     * The entry point of the program.
     * @param args the arguments.
     */
    public static void main(String[] args) {
        start();
    }

    /**
     * Makes the program run in a loop.
     */
    private static void start() {
        String choice;
        try {
            println(Color.CYAN + "Welcome to a simple bank");
            userInput(new SavingsAccount());
            println(format("\n%sEXIT?", YELLOW));
            println(format("%s: %s1 %s: %sYES", YELLOW, RED, YELLOW, RED));
            println(format("%s: %s2 %s: %sNO", YELLOW, BLUE, YELLOW, BLUE));
            printf("%s>>>: %s", Color.CYAN, Color.RESET);
            choice = SCANNER.nextLine().trim();
            switch (choice) {
                case "1" -> {
                    println(BLUE + "THANK YOU FOR USING MY PROGRAM");
                    System.exit(0);
                }
                case "2" -> start();
                default -> throw new IllegalStateException("Invalid choice");
            }
        } catch (RuntimeException runtimeException) {
            println(format("%s%s%s", RED, runtimeException.getMessage(), Color.RESET));
            start();
        }
    }

    /**
     * Method used to get user input.
     * @param savingsAccount the {@code SavingsAccount} object containing the savings account.
     */
    private static void userInput(SavingsAccount savingsAccount) {
        printf("%sEnter interest rate : ", GREEN);
        double interestRate = parseDouble(SCANNER.nextLine());
        setInterestRate.accept(interestRate);

        deposit(savingsAccount);

        showInitialBalance.accept(savingsAccount);

        printf(
                "%sPress %sD%s for another deposit or %sW%s to withdraw: %s",
                YELLOW,
                BLUE,
                YELLOW,
                RED,
                YELLOW,
                Color.RESET
        );
        processTransaction(savingsAccount, SCANNER.nextLine().charAt(0));
    }

    /**
     * Method used to process a transaction whether deposit or withdrawal.
     *
     * @param savingsAccount the {@code SavingsAccount} object containing the savings account.
     * @param choice the choice if deposit or withdraw.
     */
    private static void processTransaction(SavingsAccount savingsAccount, char choice) {
        switch (choice) {
            case 'D', 'd' -> deposit(savingsAccount);
            case 'W', 'w' -> withdraw(savingsAccount);
            default -> println(RED + "Invalid choice. The program will exit" + Color.RESET);
        }
        if (choice == 'D' || choice == 'd' || choice == 'W' || choice == 'w') showBalance.accept(savingsAccount);
    }

    /**
     * Method used to deposit an amount to a savings account.
     *
     * @param savingsAccount the {@code SavingsAccount} object containing the savings account.
     */
    private static void deposit(SavingsAccount savingsAccount) {
        printf("%sEnter deposit amount: ", Color.PURPLE);
        double amountToDeposit = parseDouble(SCANNER.nextLine());

        savingsAccount.deposit.accept(amountToDeposit);

        double balance = savingsAccount.getBalance.get();

        if (balance > 1000) savingsAccount.addInterest.accept(null);

    }

    /**
     * Method used to withdraw an amount from a savings account.
     *
     * @param savingsAccount the {@code SavingsAccount} object containing the savings account.
     */
    private static void withdraw(SavingsAccount savingsAccount) {
        printf("%sEnter amount to withdraw: ", RED);
        double amountToWithdraw = parseDouble(SCANNER.nextLine());
        String amountWithdrawn = valueOf(savingsAccount.withdraw.apply(amountToWithdraw));
        println(
                format(
                        "%sHere is your cash: %s%s",
                        GREEN,
                        Color.PURPLE,
                        getCurrencySymbol.apply("PHP").concat(amountWithdrawn)
                )
        );
    }

    /**
     * Function that returns the currency symbol using currency code.
     */
    public static final Function<String, String> getCurrencySymbol = currencyCode -> getInstance(currencyCode).getSymbol();

    /**
     * Used to print the initial balance of a savings account
     * Takes a savingsAccount the {@code SavingsAccount} object containing the savings account.
     */
    private static final Consumer<SavingsAccount> showInitialBalance =
            account -> println(
                    format(
                            "%sYour new balance is %s%s%s%s",
                            CYAN,
                            PURPLE,
                            getCurrencySymbol.apply("PHP"),
                            account.getBalance.get(),
                            RESET
                    )
            );
}

class Color {

    /**
     * Resets the text color.
     */
    public static final String RESET = "\033[0m";  // Text Reset

    /**
     * Colors text as {@code RED}
     */
    public static final String RED = "\033[0;31m";     // RED
    /**
     * Colors text as {@code GREEN}
     */
    public static final String GREEN = "\033[0;32m";   // GREEN
    /**
     * Colors text as {@code YELLOW}
     */
    public static final String YELLOW = "\033[0;33m";  // YELLOW
    /**
     * Colors text as {@code BLUE}
     */
    public static final String BLUE = "\033[0;34m";    // BLUE
    /**
     * Colors text as {@code PURPLE}
     */
    public static final String PURPLE = "\033[0;35m";  // PURPLE
    /**
     * Colors text as {@code CYAN}
     */
    public static final String CYAN = "\033[0;36m";    // CYAN

}
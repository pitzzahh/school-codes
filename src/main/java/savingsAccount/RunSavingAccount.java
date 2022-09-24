package savingsAccount;

import java.util.Currency;
import java.util.Scanner;

/**
 * Class that contains the process and running the savings account program.
 */
public class RunSavingAccount {

    /**
     * The entry point of the program.
     * @param args the arguments.
     */
    public static void main(String[] args) {
        userInput(new Scanner(System.in), new SavingsAccount());
    }

    /**
     * Method used to get user input.
     * @param scanner the {@code Scanner} object needed for user input.
     * @param savingsAccount the {@code savingsAccount.SavingsAccount} object containing the savings account.
     */
    private static void userInput(Scanner scanner, SavingsAccount savingsAccount) {
        System.out.print("Enter interest rate : ");
        double interestRate = Double.parseDouble(scanner.nextLine());
        SavingsAccount.setInterestRate(interestRate);

        deposit(scanner, savingsAccount);

        showInitialBalance(savingsAccount);

        System.out.print("Press D for another deposit or W to withdraw: ");

        processTransaction(scanner, savingsAccount, scanner.nextLine().charAt(0));
    }

    /**
     * Method used to process a transaction whether deposit or withdrawal.
     * @param scanner the {@code Scanner} object needed for user input.
     * @param savingsAccount the {@code savingsAccount.SavingsAccount} object containing the savings account.
     * @param choice the choice if deposit or withdraw.
     */
    private static void processTransaction(Scanner scanner, SavingsAccount savingsAccount, char choice) {
        switch (choice) {
            case 'D', 'd' -> deposit(scanner, savingsAccount);
            case 'W', 'w' -> withdraw(scanner, savingsAccount);
            default -> System.out.println("Invalid choice. The program will exit");
        }
        if (choice == 'D' || choice == 'd' || choice == 'W' || choice == 'w') SavingsAccount.showBalance(savingsAccount);
    }

    /**
     * Method used to deposit an amount to a savings account.
     * @param scanner the {@code Scanner} object needed for user input.
     * @param savingsAccount the {@code savingsAccount.SavingsAccount} object containing the savings account.
     */
    private static void deposit(Scanner scanner, SavingsAccount savingsAccount) {
        System.out.print("Enter deposit amount: ");
        double amountToDeposit = Double.parseDouble(scanner.nextLine());

        savingsAccount.deposit(amountToDeposit);

        double balance = savingsAccount.getBalance();

        if (balance > 1000) savingsAccount.addInterest();

    }

    /**
     * Method used to withdraw an amount from a savings account.
     * @param scanner the {@code Scanner} object needed for user input.
     * @param savingsAccount the {@code savingsAccount.SavingsAccount} object containing the savings account.
     */
    private static void withdraw(Scanner scanner, SavingsAccount savingsAccount) {
        System.out.print("Enter amount to withdraw: ");
        double amountToWithdraw = Double.parseDouble(scanner.nextLine());
        String amountWithdrawn = String.valueOf(savingsAccount.withdraw(amountToWithdraw));
        System.out.println("Here is your cash: " + getCurrencySymbol("PHP").concat(amountWithdrawn));
    }

    /**
     * Used to print the initial balance of a savings account
     * @param savingsAccount the {@code savingsAccount.SavingsAccount} object containing the savings account.
     */
    private static void showInitialBalance(SavingsAccount savingsAccount) {
        String accountBalance = String.valueOf(savingsAccount.getBalance());
        System.out.println("Your balance is " + getCurrencySymbol("PHP").concat(accountBalance));
    }

    public static String getCurrencySymbol(String currencyCode) {
        return Currency.getInstance(currencyCode).getSymbol();
    }
}

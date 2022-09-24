import java.util.Currency;

/**
 * Class used to make a savings account.
 */
public class SavingsAccount {

    private double balance;
    public static double interestRate = 0;

    /**
     * No args constructor.
     * Sets the savings account balance to 0.
     */
    public SavingsAccount() {
        this.balance = 0;
    }

    /**
     * Sets the interest rate for a savings account.
     * @param newRate the rate to be set.
     */
    public static void setInterestRate(double newRate) {
        interestRate = newRate;
    }

    /**
     * Get the interest rate of a savings account.
     * @return the interest rate of a savings account.
     */
    public static double getInterestRate() {
        return interestRate;
    }

    /**
     * Get the balance of a savings account.
     * @return the balance of a savings account.
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Add the amount to current balance.
     * @param amount the amount to be added to the current balance of a savings account.
     */
    public void deposit(double amount) {
        balance += amount;
    }

    /**
     * Withdraw a specific amount from the balance of a savings account.
     * If the amount to be withdrawn is greater than the current account balance,
     * 0 is returned.
     * @param amount the amount to be withdrawn.
     * @return the amount withdrawn.
     */
    public double withdraw(double amount) {
        if ((balance >= amount)) balance -= amount;
        else amount = 0;
        return amount;
    }

    /**
     * Adds an interest to a savings account.
     * The interest is based on the interest rate that was set.
     */
    public void addInterest() {
        double interest = getBalance() * getInterestRate();
        balance += interest;
    }

    /**
     * Shows the new balance of a savings account.
     * @param account the savings account.
     */
    public static void showBalance(SavingsAccount account) {
        System.out.printf("Your new balance is %s%s", RunSavingAccount.getCurrencySymbol("PHP"), account.getBalance());
    }
}

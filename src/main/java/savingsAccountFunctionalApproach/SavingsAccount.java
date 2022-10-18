package savingsAccountFunctionalApproach;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import static io.github.pitzzahh.util.utilities.Print.printf;
import static savingsAccountFunctionalApproach.RunSavingAccount.getCurrencySymbol;

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
     */
    public static Consumer<Double> setInterestRate = rate -> interestRate = rate;

    /**
     * Get the interest rate of a savings account.
     * Supplies the interest rate of a savings account.
     */
    public static Supplier<Double> getInterestRate = () -> interestRate;

    /**
     * Get the balance of a savings account.
     * Supplies the balance of a savings account.
     */
    public Supplier<Double> getBalance = () -> balance;

    /**
     * Add the amount to current balance.
     */
    public Consumer<Double> deposit = amount -> balance += amount;

    /**
     * Withdraw a specific amount from the balance of a savings account.
     * If the amount to be withdrawn is greater than the current account balance,
     * 0 is returned.
     * returns the amount withdrawn.
     */
    public Function<Double, Double> withdraw =
            amount -> {
                if (balance >= amount) balance -= amount;
                return (balance >= amount) ? amount :
                        amount > balance ? 0 : amount;
            };

    /**
     * Adds an interest to a savings account.
     * The interest is based on the interest rate that was set.
     */
    public Consumer<Void> addInterest = interest -> balance += getBalance.get() * getInterestRate.get();


    /**
     * Shows the new balance of a savings account.
     */
    public static Consumer<SavingsAccount> showBalance = account ->
            printf(
                    "%sYour new balance is %s%s%s",
                    Color.GREEN,
                    Color.PURPLE,
                    getCurrencySymbol.apply("PHP"),
                    account.getBalance.get()
            );
}

package oopTP;

import java.util.Currency;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * JDK version: 17 LTS
 */
public class RunAmountDue {

    public static void main(String[] args) {
        final Scanner SCANNER = new Scanner(System.in);
        final AmountDue AMOUNT_DUE = new AmountDue();
        selection(SCANNER, AMOUNT_DUE);
    }

    /**
     * Method used to process the transaction.
     * @param scanner the scanner object needed for input.
     * @param amountDue the amount due object.
     * @throws InputMismatchException if the user inputs a {@code String} when asked to enter a number.
     */
    private static void selection(Scanner scanner, AmountDue amountDue) {
        System.out.println("Select any of the following then enter values separated by spaces:");
        System.out.println("1 - Price only");
        System.out.println("2 - Price and quantity");
        System.out.println("3 - Price, quantity, and discount amount");
        System.out.print(">>>: ");
        String choice = scanner.nextLine().trim();

        // enhanced switch statements/expression might not work if JDK version is not 13+
        System.out.print("Enter value/values separated by space: ");
        try {
             double AMOUNT_DUE = switch (choice) {
                 case "1" -> amountDue.computeAmountDue(scanner.nextDouble());
                 case "2" -> amountDue.computeAmountDue(scanner.nextDouble(), scanner.nextInt());
                 case "3" -> amountDue.computeAmountDue(scanner.nextDouble(), scanner.nextInt(), scanner.nextDouble());
                 default -> throw new InputMismatchException();
             };

            System.out.println("Amount due is " + Currency.getInstance("PHP").getSymbol() + AMOUNT_DUE);
        } catch (RuntimeException mismatchException) {
            mismatchException
                    .initCause(new InputMismatchException("Input should be a number. Each value/values should be separated by a space."))
                    .printStackTrace();
        }
    }
}

/**
 * Class with overloaded method used to compute the amount due.
 */
class AmountDue {

    /**
     * The Tax. 12%
     */
    private final double TAX = .12;

    /**
     * Computes the amount due of a price with tax.
     * @param price the price.
     * @return the total amount due.
     */
    public double computeAmountDue(double price) {
        return price + (price * TAX);
    }

    /**
     * Computes the amount due of a total price added with tax.
     * @param price the price.
     * @param quantity the quantity.
     * @return the total amount due.
     */
    public double computeAmountDue(double price, int quantity) {
        return (price * quantity) + (price * TAX);
    }

    /**
     * Computes the amount due of a total price with a discount added with tax.
     * @param price the price.
     * @param quantity the quantity.
     * @param discountAmount the discounted amount.
     * @return the total amount due.
     */
    public double computeAmountDue(double price, int quantity, double discountAmount) {
        double TOTAL_PRICE_WITH_DISCOUNT = (price * quantity) - discountAmount;
        return TOTAL_PRICE_WITH_DISCOUNT + (price * TAX);
    }
}

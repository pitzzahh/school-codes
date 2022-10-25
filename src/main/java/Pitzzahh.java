
import java.util.Stack;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Pitzzahh {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stack<String> basket = new Stack<>();
        String fruitsFormatted = "'Apple', 'Orange', 'Mango', 'Guava'";
        System.out.printf("Catch any of the fruits in the basket:(%s)\n", fruitsFormatted);
        enterNumberOfFruitsToCatch(scanner, basket);
    }

    private static void enterNumberOfFruitsToCatch(Scanner scanner, Stack<String> basket) {
        System.out.print("Enter the number of fruits to catch: ");
        String input = scanner.nextLine();
        boolean isNumber = Pattern.compile("^\\d+$").matcher(input).find();
        if (isNumber) {
            System.out.println("Choose a fruit to catch: Press A for Apple, O for Orange, M for Mango, G for Guava");
            catchFruits(Integer.parseInt(input), basket, scanner);
        } else {
            System.out.println("Invalid input. Please enter a number.");
            enterNumberOfFruitsToCatch(scanner, basket);
        }
    }

    private static void insertFruit(Stack<String> basket, String fruit) {
        if ("A".equals(fruit) || "a".equals(fruit)) {
            basket.push("Apple");
        } else if ("O".equals(fruit) || "o".equals(fruit)) {
            basket.push("Orange");
        } else if ("M".equals(fruit) || "m".equals(fruit)) {
            basket.push("Mango");
        } else if ("G".equals(fruit) || "g".equals(fruit)) {
            basket.push("Guava");
        } else {
            System.out.println("Invalid input. Please enter A, O, M or G.");
        }
    }

    private static void catchFruits(int count, Stack<String> basket, Scanner scanner) {
        if (basket.size() != count) {
            System.out.printf("Fruit %d of %d: ", basket.size() + 1, count);
            insertFruit(basket, scanner.nextLine());
            catchFruits(count, basket, scanner);
        }
        printBasket(basket, scanner);
    }

    private static void printBasket(Stack<String> basket, Scanner scanner) {
        String fruits = basket.stream()
                .map(String::valueOf)
                .map(fruit -> "'" + fruit + "'")
                .collect(Collectors.joining(", ", "[", "]"));
        System.out.printf(basket.size() >= 1 ? "Fruits in the basket: %s\n" : "", fruits);
        eatFruit(basket, scanner);
    }

    private static void eatFruit(Stack<String> basket, Scanner scanner) {
        isBasketEmpty(basket);
        System.out.print("Press E to eat a fruit: ");
        String input = scanner.nextLine();
        if (input.equalsIgnoreCase("E")) {
            basket.pop();
            printBasket(basket, scanner);
        }
        else {
            System.out.println("Invalid input. Please enter E to eat a fruit");
            eatFruit(basket, scanner);
        }
    }

    private static void isBasketEmpty(Stack<String> basket) {
        if (basket.isEmpty()) {
            System.out.println("No More Fruits");
            System.exit(0);
        }
    }
}

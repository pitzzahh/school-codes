package finals.act;

import java.util.*;

/**
 * Simple Machine Learning algorithm for a Restaurant (Chat Bot)
 * @author Pitzzah
 * @since 2020-01-30
 */
public class Restaurant {

    @SuppressWarnings("BusyWait")
    public static void main(String[] args) throws InterruptedException {

        final Map<String, String> RESPONSES = getResponse();
        final Scanner SCANNER = new Scanner(System.in);
        final Random RANDOM = new Random();
        final String MY_NAME = "Peter John";
        final String INTRO = "Hello, I am the restaurant bot. What would you like to do?";
        final String NOT_FOUND = "I'm sorry, I'm not sure what you mean. Can you please rephrase your question?%n";
        System.out.println("BOT: ".concat(INTRO));

        while (true) {
            String message = user(SCANNER);
            boolean found = RESPONSES.keySet().stream().anyMatch(message::contains);
            String finalMessage = Arrays.stream(getFormattedMessage(message.contains("?"), message)
                            .split("\\s"))
                    .filter(RESPONSES::containsKey)
                    .findAny()
                    .orElse("");

            Thread.sleep(RANDOM.nextInt(1000) + 1);
            System.out.print("BOT: ");
            if (found) {
                if (message.equals("exit") || message.equals("end")) {
                    System.out.printf(RESPONSES.get(finalMessage), MY_NAME);
                    break;
                }
                if (RESPONSES.get(finalMessage) == null) System.out.printf(NOT_FOUND);
                else System.out.printf(RESPONSES.get(finalMessage), MY_NAME);
            } else System.out.printf(NOT_FOUND);
        }
    }

    static String getFormattedMessage(boolean contains, String message) {
        return contains ? message.replace("?", "") : message;
    }

    static String user(Scanner input) {
        System.out.print("User: ");
        return input.nextLine();
    }

    static Map<String, String> getResponse() {
        final Map<String, String> responses = new HashMap<>();
        responses.put("hello", "Hello %s, how may I help you?%n");
        responses.put("hi", "Hello %s, how may I help you?%n");
        responses.put("hii", "Hello %s, how may I help you?%n");
        responses.put("order", "What would you like to order?%n");
        responses.put("pay", "Please pay %s%n");
        responses.put("dine", "Dine in is selected, Please wait and we will bring your order to you%n");
        responses.put("take", "Take out is selected, Please wait and we will bring your order to you%n");
        responses.put("thanks", "Thank you %s for eating in our Restaurant%n");
        responses.put("hours", "Our hours of operation are Monday-Saturday from 11:30am-9:00pm and Sunday from 11:30am-8:00pm.%n");
        responses.put("time", "Our hours of operation are Monday-Saturday from 11:30am-9:00pm and Sunday from 11:30am-8:00pm.%n");
        responses.put("exit", "Thank you for contacting us. Come back again!%n");
        responses.put("end", "Thank you for contacting us. Come back again!%n");
        responses.put("your name", "My name is Resto Bot, I am here to serve you!%n");
        responses.put("yourname", "My name is Resto Bot, I am here to serve you!%n");
        responses.put("hate you", "I am so sorry to hear that. Is there any things that I can help with?!%n");
        responses.put("my name", "Your name is %s, that is what you said%n");
        responses.put("menu", "Here is the menu: we offer : pizza : carbonara deluxe : pesto pasta : coke : water :. Would you like to to hear more?%n");
        responses.put("more", "We also offer : chicken wings : chicken nuggets : french fries : onion rings :. Would you like to to hear more?%n");
        responses.put("yes", "We also offer : chicken wings : chicken nuggets : french fries : onion rings :. Would you like to to hear more?%n");
        return responses;
    }
}

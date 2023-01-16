package finals.act;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Restaurant {

    @SuppressWarnings("BusyWait")
    public static void main(String[] args) throws InterruptedException {

        final Map<String, String> response = getResponse();
        final Scanner scanner = new Scanner(System.in);

        final String intro = "Hello, I am the restaurant bot. What would you like to do?";
        System.out.println("BOT: ".concat(intro));

        while (true) {
            String message = user(scanner);
            boolean found = response.keySet().stream().anyMatch(message::contains);
            String finalMessage = Arrays.stream(getFormattedMessage(message.contains("?"), message)
                            .split("\\s"))
                    .filter(response::containsKey)
                    .findAny()
                    .orElse("");

            Thread.sleep(1000);
            System.out.print("BOT: ");
            if (found) {
                if (message.equals("exit") || message.equals("end")) {
                    System.out.printf(response.get(finalMessage), "Peter");
                    break;
                }
                System.out.printf(response.get(finalMessage), "Peter");
            } else System.out.printf("I'm sorry, I'm not sure what you mean. Can you please rephrase your question?%n");
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
        responses.put("order", "What would you like to order?%n");
        responses.put("pay", "Please pay  %s%n");
        responses.put("dine", "Dine in is selected, Please wait and we will bring your order to you%n");
        responses.put("take", "Take out is selected, Please wait and we will bring your order to you%n");
        responses.put("thanks", "Thank you %s for eating in our Restaurant%n");
        responses.put("hours", "Our hours of operation are Monday-Saturday from 11:30am-9:00pm and Sunday from 11:30am-8:00pm.%n");
        responses.put("time", "Our hours of operation are Monday-Saturday from 11:30am-9:00pm and Sunday from 11:30am-8:00pm.%n");
        responses.put("exit", "Thank you for contacting us. Come back again!%n");
        responses.put("end", "Thank you for contacting us. Come back again!%n");
        return responses;
    }
}

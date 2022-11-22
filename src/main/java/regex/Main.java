package regex;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String firstWord;
        String secondWord;
        String sub;

        try {
            System.out.print("Enter the First Word : ");
            firstWord = scanner.nextLine().trim();
            System.out.print("Enter the Second Word: ");
            secondWord = scanner.nextLine().trim();

            sub = firstWord.substring(firstWord.length() - 2);

            Matcher matcher = Pattern.compile("[a-zA-Z]{1,2}" + sub).matcher(secondWord);

            System.out.println(matcher.matches() ? String.format("%s rhymes with %s", secondWord, firstWord) : "I'm not sure!Sorry!");
        } catch(RuntimeException runtimeException) {
            runtimeException.printStackTrace();
        }
        scanner.close();
    }
}
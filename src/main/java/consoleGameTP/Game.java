package consoleGameTP;

import static consoleGameTP.Utility.*;
import java.util.concurrent.TimeUnit;
import java.security.SecureRandom;
import java.util.stream.IntStream;
import java.util.Optional;
import java.util.Scanner;

public class Game {

    public static void main(String[] args) throws InterruptedException {
        Game game = new Game();
        // create a greeting text and print it
        System.out.printf("%s%s%s%n", CYAN_BOLD_BRIGHT, "Welcome to the game!", RESET);
        game.start();
    }

    private void start() throws InterruptedException {
        String choice;
        do {

            printLine(23);
            System.out.printf("%n%s|%s%s%s|%s%n",
                    YELLOW_BOLD_BRIGHT,
                    BLUE_BOLD_BRIGHT,
                    "Select your game mode",
                    YELLOW_BOLD_BRIGHT,
                    RESET
            );
            printLine(23);
            System.out.printf("%n%s%n", ": 1 : Auto mode");
            System.out.printf("%s%n", ": 2 : Survival mode");

            System.out.print("Enter your choice: ");
            choice = Utility.INPUT.nextLine().trim();

            if (choice.equals("1")) autoMode();
            else if (choice.equals("2")) survivalMode();
            else System.out.println("Invalid input");
        } while (!choice.equals("1") && !choice.equals("2"));
    }

    private void autoMode() throws InterruptedException {
        printLine(12);
        System.out.printf("%n%s%n", "|Auto mode|");
        printLine(12);

        Player player = new Player();
        Player computer = new Player();
        SecureRandom random = new SecureRandom();

        System.out.printf("%n%sEnter your name: %s", YELLOW_BOLD_BRIGHT, RESET);
        String name = Utility.INPUT.nextLine().trim();
        System.out.println(PURPLE_BOLD_BRIGHT + "Hello " + name + "!" + RESET);

        player.setName(name);

        setRandomHealth(player, random);
        setRandomArmor(player, random);
        setRandomWeapon(player, random);

        continuePlay(player, computer, random);
    }

    private void survivalMode() throws InterruptedException {
        printLine(22);
        printLine(14);
        System.out.printf("%n%s%s%s%n", CYAN_BOLD_BRIGHT, "|Survival mode|", RESET);
        printLine(14);
        System.out.println();
        printLine(22);

        Player player = new Player();
        Player computer = new Player();
        SecureRandom random = new SecureRandom();

        System.out.printf("%n%s", "Enter your name: ");
        String name = Utility.INPUT.nextLine().trim();
        player.setName(name);

        printLine(22);

        System.out.printf("%n%s%n", "LIST OF ARMORS");
        IArmor.printArmors();
        System.out.print("Enter your armor: ");
        player.setArmor(Utility.INPUT.nextLine().trim().equals("1") ? new IronArmor() : new GoldArmor());

        printLine(22);

        System.out.printf("%n%s", "Enter your health: ");
        String health = Utility.INPUT.nextLine().trim();
        player.setHealth(Integer.parseInt(health));

        printLine(22);

        System.out.printf("%n%s%n", "LIST OF WEAPONS");
        IWeapon.printWeapons();
        System.out.print("Enter your weapon: ");
        player.setWeapon(Utility.INPUT.nextLine().trim().equals("1") ? new Fist() : new Sword());

        printLine(22);

        continuePlay(player, computer, random);
    }

    private void continuePlay(Player player, Player computer, SecureRandom random) throws InterruptedException {

        computer.setName("Computer");
        setRandomHealth(computer, random);
        setRandomArmor(computer, random);
        setRandomWeapon(computer, random);

        do {

            player.printInfo(player.getArmor(), player.getWeapon());
            TimeUnit.MILLISECONDS.sleep(6000);
            computer.printInfo(computer.getArmor(), computer.getWeapon());
            TimeUnit.MILLISECONDS.sleep(6000);
            attackRandom(player, computer, random);
            TimeUnit.MILLISECONDS.sleep(4000);

        } while (!computer.isDefeated() && !player.isDefeated());

        checkWinning(player);

        checkWinning(computer);

        System.out.println(MESSAGE[random.nextInt(MESSAGE.length)]);
    }

    private static void checkWinning(Player player) {
        if (player.isDefeated()) System.out.printf("%n%s lost!%n", player.name());
        else System.out.printf("%n%s won!%n", player.name());
    }

    private void setRandomHealth(Player player, SecureRandom random) {
        player.setHealth(random.nextInt(100) + 1);
    }

    private void setRandomArmor(Player player, SecureRandom random) {
        player.setArmor((random.nextInt(100) + 1) % 2 == 0 ? new GoldArmor() : new IronArmor());
    }

    private void setRandomWeapon(Player player, SecureRandom random) {
        player.setWeapon((random.nextInt(100) + 1) % 2 == 0 ? new Sword() : new Fist());
    }

    private void attackRandom(Player player, Player computer, SecureRandom random) {
        int randomNumber = random.nextInt(100) + 1;
        if (randomNumber % 2 == 0) {
            computer.defend(player.attack(computer.name()));
            setRandomHeal(computer, random);
        }
        else {
            player.defend(computer.attack(player.name()));
            setRandomHeal(player, random);
        }
    }

    private void setRandomHeal(Player player, SecureRandom random) {
        if (random.nextInt() % 2 == 0) {
            player.heal();
        }
    }

    public static void printLine(int count) {
        IntStream.range(0, count)
                .mapToObj(i -> PURPLE_BOLD_BRIGHT + "-" + RESET)
                .forEach(System.out::print);
    }

}

interface IPlayer {

    default String name() {
        return "Player";
    }

    default int health() {
        return 100;
    }

    int attack(String enemyName);

    void defend(int damage);

    void heal();

    default boolean isDefeated() {
        return health() <= 0;
    }

    default void printInfo(IArmor armor, IWeapon weapon) {
        System.out.println();
        Game.printLine(23);
        System.out.printf("%n%s%s%s", YELLOW_BOLD_BRIGHT, ":Player info:", CYAN_BOLD_BRIGHT);
        System.out.printf("%n%s%s%s%s", "Name: ", YELLOW_BOLD_BRIGHT, name(), CYAN_BOLD_BRIGHT);
        System.out.printf("%n%s%s%s%s", "Health: ", health() <= 20 ? RED_BOLD_BRIGHT : BLUE_BOLD_BRIGHT, health(), RESET);
        armor.printInfo();
        weapon.printInfo();
        Game.printLine(23);
    }
}

interface IWeapon {

    String name();

    int damage();

    static void printWeapons() {
        System.out.printf("%s:%s 1 %s:%s Fist", CYAN_BOLD_BRIGHT, YELLOW_BOLD_BRIGHT, CYAN_BOLD_BRIGHT, RESET);
        System.out.printf("%s:%s 2 %s:%s Sword", CYAN_BOLD_BRIGHT, YELLOW_BOLD_BRIGHT, CYAN_BOLD_BRIGHT, RESET);
    }

    default void printInfo() {
        System.out.printf("%n%s%s%s", YELLOW_BOLD_BRIGHT, ":Weapon info:", CYAN_BOLD_BRIGHT);
        System.out.printf("%n%s%s%s%s", "Name: ", PURPLE_BOLD_BRIGHT, name(), CYAN_BOLD_BRIGHT);
        System.out.printf("%n%s%s%s%n", "Damage: ", RED_BOLD_BRIGHT, damage());
    }

}

interface IArmor {
    String name();

    int defense();

    static void printArmors() {
        System.out.printf("%s:%s 1 %s:%s Iron Armor", CYAN_BOLD_BRIGHT, YELLOW_BOLD_BRIGHT, CYAN_BOLD_BRIGHT, RESET);
        System.out.printf("%s:%s 2 %s:%s Gold Armor", CYAN_BOLD_BRIGHT, YELLOW_BOLD_BRIGHT, CYAN_BOLD_BRIGHT, RESET);
    }

    default void printInfo() {
        System.out.printf("%n%s%s%s", YELLOW_BOLD_BRIGHT, ":Armor info:", CYAN_BOLD_BRIGHT);
        System.out.printf("%n%s%s%s%s", "Name: ", PURPLE_BOLD_BRIGHT, name(), CYAN_BOLD_BRIGHT);
        System.out.printf("%n%s%s%s%n", "Defense: ", RED_BOLD_BRIGHT, defense());
    }
}

class Player implements IPlayer {

    private String name;
    private int health;
    private IArmor armor;
    private IWeapon weapon;

    public void setName(String name) {
        this.name = name;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setWeapon(IWeapon weapon) {
        this.weapon = weapon;
    }

    public void setArmor(IArmor armor) {
        this.armor = armor;
    }

    public IArmor getArmor() {
        return armor;
    }

    public IWeapon getWeapon() {
        return weapon;
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public int health() {
        return health + Optional.ofNullable(getArmor()).map(IArmor::defense).orElse(0);
    }

    @Override
    public int attack(String enemyName) {
        System.out.printf("%n%s attacks %s with %s%n", name(), enemyName, weapon.name());
        return weapon.damage();
    }

    @Override
    public void defend(int damage) {
        health -= damage;
        System.out.printf("%s defends %d damage%n", name, damage);
        printCurrentHealth();
    }

    private void printCurrentHealth() {
        System.out.printf("%s health is now %d%n", name(), health() <= 0 ? 0 : health());
    }

    @Override
    public void heal() {
        health += new SecureRandom().nextInt(20) + 1;
        System.out.printf("%s heal yourself!%n", name());
        printCurrentHealth();
    }

}

class Fist implements IWeapon {

    @Override
    public String name() {
        return "Fist";
    }

    @Override
    public int damage() {
        return 20;
    }

}

class Sword implements IWeapon {

    @Override
    public String name() {
        return "Sword";
    }

    @Override
    public int damage() {
        return 40;
    }

}

class IronArmor implements IArmor {

    @Override
    public String name() {
        return "Iron Armor";
    }

    @Override
    public int defense() {
        return 40;
    }
}

class GoldArmor implements IArmor {

    @Override
    public String name() {
        return "Gold Armor";
    }

    @Override
    public int defense() {
        return 80;
    }
}

interface Utility {
    // Reset
    String RESET = "\033[0m";  // Text Reset
    Scanner INPUT = new Scanner(System.in);

    String RED_BOLD_BRIGHT = "\033[1;91m";   // RED
    String GREEN_BOLD_BRIGHT = "\033[1;92m"; // GREEN
    String YELLOW_BOLD_BRIGHT = "\033[1;93m";// YELLOW
    String BLUE_BOLD_BRIGHT = "\033[1;94m";  // BLUE
    String PURPLE_BOLD_BRIGHT = "\033[1;95m";// PURPLE
    String CYAN_BOLD_BRIGHT = "\033[1;96m";  // CYAN

    String[] MESSAGE = {
            GREEN_BOLD_BRIGHT + "|> Computer: I only want to see whether you will let me win this game, or beat it." + RESET,
            GREEN_BOLD_BRIGHT + "|> Computer: You win your battles or I'll destroy you!" + RESET,
            GREEN_BOLD_BRIGHT + "|> Computer: It is not difficult to capture a fortress but it is difficult to win a RandomGame." + RESET,
            GREEN_BOLD_BRIGHT + "|> Computer: What did you win in your deal about me?" + RESET,
            GREEN_BOLD_BRIGHT + "|> Computer: You really want to win this bet, don't you? haha Congrats!" + RESET,
            GREEN_BOLD_BRIGHT + "|> Computer: After you beat me and win the game, there's no way you can fire me again." + RESET,
            GREEN_BOLD_BRIGHT + "|> Computer: You thinking you're gonna win this game, haha you're right" + RESET,
            GREEN_BOLD_BRIGHT + "|> Computer: You know you can't win a battle without me. you against AI, stupid" + RESET
    };


}
package bloodBank;

import java.util.Scanner;

public class RunBloodData {

    @SuppressWarnings("InfiniteLoopStatement")
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        while (true) {
            BloodData bloodData;
            System.out.print("Enter blood type of patient: ");
            final String bloodType = scanner.nextLine();
            System.out.print("Enter the Rhesus factor(+ or -): ");
            final String rhesusFactor = scanner.nextLine();
            if (bloodType.trim().isEmpty() && rhesusFactor.trim().isEmpty()) bloodData = new BloodData();
            else bloodData = new BloodData(bloodType, rhesusFactor);
            bloodData.display();
        }
    }
}

/**
 * Immutable class.
 * fields can be declared as final.
 */
class BloodData {
    private final String bloodType;
    private final String rhFactor;

    public BloodData() {
        this.bloodType = "O";
        this.rhFactor = "+";
    }

    public BloodData(String bloodType, String rhFactor) {
        this.bloodType = bloodType;
        this.rhFactor = rhFactor;
    }

    public void display() {
        System.out.printf("%s%s is added to the blood bank.\n", this.bloodType, this.rhFactor);
    }

}

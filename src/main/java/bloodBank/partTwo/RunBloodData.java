package bloodBank.partTwo;

import java.util.Scanner;

public class RunBloodData {

    @SuppressWarnings("InfiniteLoopStatement")
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        while (true) {
            BloodData bloodData = new BloodData();
            System.out.print("Enter blood type of patient: ");
            final String bloodType = scanner.nextLine();
            System.out.print("Enter the Rhesus factor(+ or -): ");
            final String rhesusFactor = scanner.nextLine();
            if (!bloodType.trim().isEmpty() && !rhesusFactor.trim().isEmpty()) {
                bloodData.setBloodType(bloodType);
                bloodData.setRhFactor(rhesusFactor);
            }
            bloodData.display();
        }
    }
}

/**
 * Immutable class.
 * fields can be declared as final.
 */
class BloodData {
    private String bloodType;
    private String rhFactor;

    public BloodData() {
        this.bloodType = "O";
        this.rhFactor = "+";
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    public String getBloodType() {
        return bloodType;
    }

    public void setRhFactor(String rhFactor) {
        this.rhFactor = rhFactor;
    }

    public String getRhFactor() {
        return rhFactor;
    }

    public void display() {
        System.out.printf("%s%s is added to the blood bank.\n\n", getBloodType(), getRhFactor());
    }

}

import ce306.shapoval.*;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * The <code>LampApp</code> class is a driver class that tests the functionality
 * of the <code>Lamp</code> class. It provides a console menu for users to interact
 * with a lamp object, allowing them to charge and discharge the battery, check the
 * status, and retrieve lamp information.
 */
public class LampApp {
    /**
     * The entry point of the application. It initializes the <code>Lamp</code> object
     * and displays a menu for user interaction. The user can choose from various options
     * such as getting lamp information, charging the battery, discharging the battery,
     * checking the battery status, and exiting the application.
     *
     * @param args Command line arguments (not used in this application)
     */
    public static void main(String[] args) {
        // Scanner to read user input
        Scanner scanner = new Scanner(System.in);

        // Creating Lamp objects
        Lamp lamp = null;
        try {
            lamp = new Lamp(new LampBattery(), new LampType(), new LampSocket());
        } catch (FileNotFoundException e) {
            System.out.println("Error: Unable to create file for logging data.");
            return;
        }

        boolean exit = false;

        while (!exit) {
            // Displaying menu options
            System.out.println("===== Lamp Menu =====");
            System.out.println("1. Get lamp information");
            System.out.println("2. Charge battery");
            System.out.println("3. Discharge battery");
            System.out.println("4. Check battery status");
            System.out.println("5. Check current battery capacity");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println(lamp.getLampInfo());
                    break;
                case 2:
                    System.out.print("Enter charge amount: ");
                    double chargeAmount = scanner.nextDouble();
                    if (lamp.chargeBattery(chargeAmount)) {
                        System.out.println("Battery charged.");
                    } else {
                        System.out.println("Failed to charge battery.");
                    }
                    break;
                case 3:
                    System.out.print("Enter discharge amount: ");
                    double dischargeAmount = scanner.nextDouble();
                    if (lamp.dischargeBattery(dischargeAmount)) {
                        System.out.println("Battery discharged.");
                    } else {
                        System.out.println("Failed to discharge battery.");
                    }
                    break;
                case 4:
                    System.out.println("Battery status: " + lamp.checkLampStatus());
                    break;
                case 5:
                    System.out.println("Current battery capacity: " + lamp.getCurrentBatteryCapacity());
                    break;
                case 6:
                    System.out.println("Exiting.");
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }

        // Releasing resources
        lamp.dispose();
        scanner.close();
    }
}

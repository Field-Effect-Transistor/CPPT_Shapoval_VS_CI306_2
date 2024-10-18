import ce306.shapoval.lab3.*;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * The <code>SmartLampApp</code> class is a driver class that tests the functionality
 * of the <code>SmartLamp</code> class. It provides a console menu for users to interact
 * with a smart lamp object, allowing them to change the color, charge and discharge the battery,
 * check the status, and retrieve lamp information.
 */
public class SmartLampApp {
    /**
     * The entry point of the application. It initializes the <code>SmartLamp</code> object
     * and displays a menu for user interaction. The user can choose from various options
     * such as getting lamp information, changing the lamp color, charging the battery,
     * discharging the battery, checking the battery status, and exiting the application.
     *
     * @param args Command line arguments (not used in this application)
     */
    public static void main(String[] args) {
        // Scanner to read user input
        Scanner scanner = new Scanner(System.in);

        // Creating SmartLamp object
        SmartLamp smartLamp = null;
        try {
            smartLamp = new SmartLamp(new LampBattery(), new LampSocket());
        } catch (FileNotFoundException e) {
            System.out.println("Error: Unable to create file for logging data.");
            return;
        }

        boolean exit = false;

        while (!exit) {
            // Displaying menu options
            System.out.println("===== Smart Lamp Menu =====");
            System.out.println("1. Get lamp information");
            System.out.println("2. Change lamp color");
            System.out.println("3. Charge battery");
            System.out.println("4. Discharge battery");
            System.out.println("5. Check battery status");
            System.out.println("6. Check current battery capacity");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println(smartLamp.getLampInfo());
                    break;
                case 2:
                    System.out.print("Enter RGB values (r g b): ");
                    int r = scanner.nextInt();
                    int g = scanner.nextInt();
                    int b = scanner.nextInt();
                    smartLamp.setColor(r, g, b);
                    break;
                case 3:
                    System.out.print("Enter charge amount: ");
                    double chargeAmount = scanner.nextDouble();
                    if (smartLamp.chargeBattery(chargeAmount)) {
                        System.out.println("Battery charged.");
                    } else {
                        System.out.println("Failed to charge battery.");
                    }
                    break;
                case 4:
                    System.out.print("Enter discharge amount: ");
                    double dischargeAmount = scanner.nextDouble();
                    if (smartLamp.dischargeBattery(dischargeAmount)) {
                        System.out.println("Battery discharged.");
                    } else {
                        System.out.println("Failed to discharge battery.");
                    }
                    break;
                case 5:
                    System.out.println("Battery status: " + smartLamp.checkLampStatus());
                    break;
                case 6:
                    System.out.println("Current battery capacity: " + smartLamp.getCurrentBatteryCapacity());
                    break;
                case 7:
                    System.out.println("Exiting.");
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }

        // Releasing resources
        smartLamp.dispose();
        scanner.close();
    }
}

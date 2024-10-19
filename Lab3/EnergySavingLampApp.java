import ce306.shapoval.lab3.*;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * The <code>EnergySavingLampApp</code> class is a driver class that tests the functionality
 * of the <code>EnergySavingLamp</code> class, which extends the <code>Lamp</code> class.
 * It provides a console menu for users to interact with both the base class functionalities
 * (like charging and discharging the battery) and the extended functionalities (turning the
 * lamp on and off, checking energy efficiency).
 */
public class EnergySavingLampApp {
    /**
     * The entry point of the application. It initializes the <code>EnergySavingLamp</code> object
     * and displays a menu for user interaction. The user can choose from various options such as
     * turning the lamp on/off, charging/discharging the battery, checking the lamp status,
     * and getting lamp information, including its energy efficiency.
     *
     * @param args Command line arguments (not used in this application)
     */
    public static void main(String[] args) {
        // Scanner to read user input
        Scanner scanner = new Scanner(System.in);

        // Creating EnergySavingLamp object
        EnergySavingLamp lamp = null;
        try {
            lamp = new EnergySavingLamp(new LampBattery(), new LampSocket(), 0.8); // 80% efficiency
        } catch (FileNotFoundException e) {
            System.out.println("Error: Unable to create file for logging data.");
            return;
        }

        boolean exit = false;

        while (!exit) {
            // Displaying menu options
            System.out.println("===== Energy-Saving Lamp Menu =====");
            System.out.println("1. Turn lamp on");
            System.out.println("2. Turn lamp off");
            System.out.println("3. Check if the lamp is on");
            System.out.println("4. Get lamp information");
            System.out.println("5. Charge battery");
            System.out.println("6. Discharge battery");
            System.out.println("7. Check battery status");
            System.out.println("8. Check current battery capacity");
            System.out.println("9. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    lamp.turnOn();
                    System.out.println("The lamp is now on.");
                    break;
                case 2:
                    lamp.turnOff();
                    System.out.println("The lamp is now off.");
                    break;
                case 3:
                    System.out.println(lamp.isOn() ? "The lamp is on." : "The lamp is off.");
                    break;
                case 4:
                    System.out.println(lamp.getLampInfo());
                    break;
                case 5:
                    System.out.print("Enter charge amount: ");
                    double chargeAmount = scanner.nextDouble();
                    if (lamp.chargeBattery(chargeAmount)) {
                        System.out.println("Battery charged.");
                    } else {
                        System.out.println("Failed to charge battery.");
                    }
                    break;
                case 6:
                    System.out.print("Enter discharge amount: ");
                    double dischargeAmount = scanner.nextDouble();
                    if (lamp.dischargeBattery(dischargeAmount)) {
                        System.out.println("Battery discharged.");
                    } else {
                        System.out.println("Failed to discharge battery.");
                    }
                    break;
                case 7:
                    System.out.println("Battery status: " + lamp.checkLampStatus());
                    break;
                case 8:
                    System.out.println("Current battery capacity: " + lamp.getCurrentBatteryCapacity());
                    break;
                case 9:
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

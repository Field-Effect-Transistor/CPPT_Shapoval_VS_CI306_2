import ce306.shapoval.*;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Driver class to test the Lamp class functionality
 */
public class LampApp {
    public static void main(String[] args) {
        // Scanner to read user input
        Scanner scanner = new Scanner(System.in);

        // Creating Lamp objects
        Lamp lamp = null;
        try {
            lamp = new Lamp(new LampBattery(), new LampType(), new LampSocket());
        } catch (FileNotFoundException e) {
            System.out.println("Помилка: Неможливо створити файл для запису даних.");
            return;
        }

        boolean exit = false;

        while (!exit) {
            // Displaying menu options
            System.out.println("===== Lamp Menu =====");
            System.out.println("1. Отримати інформацію про лампу");
            System.out.println("2. Зарядити батарею");
            System.out.println("3. Розрядити батарею");
            System.out.println("4. Перевірити статус батареї");
            System.out.println("5. Перевірити поточну ємність батареї");
            System.out.println("6. Вийти");
            System.out.print("Введіть ваш вибір: ");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println(lamp.getLampInfo());
                    break;
                case 2:
                    System.out.print("Введіть кількість заряду: ");
                    double chargeAmount = scanner.nextDouble();
                    if (lamp.chargeBattery(chargeAmount)) {
                        System.out.println("Батарею заряджено.");
                    } else {
                        System.out.println("Не вдалося зарядити батарею.");
                    }
                    break;
                case 3:
                    System.out.print("Введіть кількість розряду: ");
                    double dischargeAmount = scanner.nextDouble();
                    if (lamp.dischargeBattery(dischargeAmount)) {
                        System.out.println("Батарею розряджено.");
                    } else {
                        System.out.println("Не вдалося розрядити батарею.");
                    }
                    break;
                case 4:
                    System.out.println("Статус батареї: " + lamp.checkLampStatus());
                    break;
                case 5:
                    System.out.println("Поточна ємність батареї: " + lamp.getCurrentBatteryCapacity());
                    break;
                case 6:
                    System.out.println("Вихід.");
                    exit = true;
                    break;
                default:
                    System.out.println("Невірний вибір.");
            }
        }

        // Releasing resources
        lamp.dispose();
        scanner.close();
    }
}

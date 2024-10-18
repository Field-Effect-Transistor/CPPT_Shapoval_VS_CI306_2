import ce306.shapoval.lab6.*;
import java.util.Scanner;

/**
 * The <code>CabinetApp</code> class serves as a driver program to demonstrate the functionality
 * of the <code>Cabinet</code> class. It allows users to interact with the cabinet to add, 
 * remove, and find items based on their volume.
 */
public class CabinetApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Cabinet<Item> cabinet = new Cabinet<>(); // Create a cabinet to store items

        boolean exit = false;

        while (!exit) {
            // Displaying menu options
            System.out.println("===== Cabinet Menu =====");
            System.out.println("1. Add item");
            System.out.println("2. Remove item");
            System.out.println("3. Find minimum item");
            System.out.println("4. Display all items");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    // Adding an item
                    System.out.print("Enter item name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter item volume: ");
                    double volume = scanner.nextDouble();
                    Item newItem = new Item(name, volume);
                    cabinet.addItem(newItem);
                    System.out.println("Item added: " + newItem);
                    break;

                case 2:
                    // Removing an item
                    System.out.print("Enter item name to remove: ");
                    String itemNameToRemove = scanner.nextLine();
                    Item itemToRemove = null;
                    for (Item item : cabinet.getItems()) {
                        if (item.getName().equalsIgnoreCase(itemNameToRemove)) {
                            itemToRemove = item;
                            break;
                        }
                    }
                    if (itemToRemove != null && cabinet.removeItem(itemToRemove)) {
                        System.out.println("Item removed: " + itemToRemove);
                    } else {
                        System.out.println("Item not found.");
                    }
                    break;

                case 3:
                    // Finding the minimum item
                    Item minItem = cabinet.findMin();
                    if (minItem != null) {
                        System.out.println("Minimum item: " + minItem);
                    } else {
                        System.out.println("Cabinet is empty.");
                    }
                    break;

                case 4:
                    // Displaying all items
                    System.out.println("Items in the cabinet:");
                    for (Item item : cabinet.getItems()) {
                        System.out.println(item);
                    }
                    break;

                case 5:
                    // Exiting
                    System.out.println("Exiting.");
                    exit = true;
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }
}

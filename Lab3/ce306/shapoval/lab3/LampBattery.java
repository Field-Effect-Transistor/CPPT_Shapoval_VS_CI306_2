package ce306.shapoval.lab3;

/**
 * The <code>LampBattery</code> class represents the battery used in a lamp.
 * It includes fields for nominal voltage, nominal capacity, and current capacity, 
 * and provides methods to charge and discharge the battery, as well as to check its status.
 */
public class LampBattery {
    private double nominalVoltage;    // The nominal voltage of the battery (in volts)
    private double nominalCapacity;   // The nominal capacity of the battery (in mAh)
    private double currentCapacity;   // The current capacity of the battery (in mAh)

    /**
     * Default constructor that initializes the battery with default values.
     * Nominal voltage is set to 3.7V and capacity to 1500mAh.
     * The current capacity is set to be fully charged.
     */
    public LampBattery() {
        nominalVoltage = 3.7;
        nominalCapacity = 1500;
        currentCapacity = nominalCapacity;
    }

    /**
     * Constructor that initializes the battery with specified nominal voltage and capacity.
     * The current capacity is set to match the nominal capacity (fully charged).
     * 
     * @param nominalVoltage The nominal voltage of the battery (in volts)
     * @param nominalCapacity The nominal capacity of the battery (in mAh)
     */
    public LampBattery(double nominalVoltage, double nominalCapacity) {
        this.nominalVoltage = nominalVoltage;
        this.nominalCapacity = nominalCapacity;
        this.currentCapacity = nominalCapacity;
    }

    /**
     * Constructor that initializes the battery with specified nominal voltage, 
     * nominal capacity, and current capacity.
     * 
     * @param nominalVoltage The nominal voltage of the battery (in volts)
     * @param nominalCapacity The nominal capacity of the battery (in mAh)
     * @param currentCapacity The current capacity of the battery (in mAh)
     */
    public LampBattery(double nominalVoltage, double nominalCapacity, double currentCapacity) {
        this.nominalVoltage = nominalVoltage;
        this.nominalCapacity = nominalCapacity;
        this.currentCapacity = currentCapacity;
    }

    /**
     * Charges the battery by the specified amount. 
     * The battery cannot be overcharged beyond its nominal capacity.
     * 
     * @param amount The amount to charge the battery by (in mAh)
     */
    public void charge(double amount) {
        if (amount < 0) {
            System.out.println("Cannot charge the battery with a negative value.");
            return;
        }
        currentCapacity += amount;
        if (currentCapacity > nominalCapacity) {
            currentCapacity = nominalCapacity; // Limit the battery capacity to the nominal value
        }
    }

    /**
     * Discharges the battery by the specified amount.
     * The battery cannot have a negative capacity.
     * 
     * @param amount The amount to discharge the battery by (in mAh)
     */
    public void discharge(double amount) {
        if (amount < 0) {
            System.out.println("Cannot discharge the battery with a negative value.");
            return;
        }
        currentCapacity -= amount;
        if (currentCapacity < 0) {
            currentCapacity = 0; // Prevent the capacity from becoming negative
        }
    }

    /**
     * Returns the nominal voltage of the battery.
     * 
     * @return The nominal voltage (in volts)
     */
    public double getNominalVoltage() {
        return nominalVoltage;
    }

    /**
     * Returns the nominal capacity of the battery.
     * 
     * @return The nominal capacity (in mAh)
     */
    public double getNominalCapacity() {
        return nominalCapacity;
    }

    /**
     * Returns the current capacity of the battery.
     * 
     * @return The current capacity (in mAh)
     */
    public double getCurrentCapacity() {
        return currentCapacity;
    }

    /**
     * Checks the status of the battery based on its current capacity.
     * 
     * @return A string indicating the current status of the battery:
     *         - "Battery is discharged" if the capacity is 0
     *         - "Battery is almost discharged" if the capacity is less than 20% of nominal
     *         - "Battery is in normal condition" otherwise
     */
    public String checkStatus() {
        if (currentCapacity == 0) {
            return "Battery is discharged.";
        } else if (currentCapacity < nominalCapacity * 0.2) {
            return "Battery is almost discharged.";
        } else {
            return "Battery is in normal condition.";
        }
    }
}

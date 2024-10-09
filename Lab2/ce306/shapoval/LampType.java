package ce306.shapoval;

/**
 * The <code>LampType</code> class represents various types of lamps with their energy efficiency 
 * and lifespan properties.
 * It includes methods to display lamp details and compare energy efficiency between different lamps.
 */
public class LampType {
    // Fields to store the properties of the lamp
    private String type;             // The type of the lamp (e.g., LED, Incandescent)
    private double energyEfficiency; // Energy efficiency measured in watts per lumen (W/Lm)
    private double lifespan;         // The lifespan of the lamp in hours

    /**
     * Default constructor that initializes the lamp to an incandescent type.
     * Sets default energy efficiency to 12 W/Lm and lifespan to 1000 hours.
     */
    public LampType() {
        type = "Incandescent Lamps";
        energyEfficiency = 12;
        lifespan = 1000;
    }

    /**
     * Constructor to initialize the lamp with specific type, energy efficiency, and lifespan.
     * 
     * @param type The type of the lamp (e.g., LED Lamps, Halogen Lamps)
     * @param energyEfficiency The energy efficiency of the lamp (W/Lm)
     * @param lifespan The lifespan of the lamp in hours
     */
    public LampType(String type, double energyEfficiency, double lifespan) {
        this.type = type;
        this.energyEfficiency = energyEfficiency;
        this.lifespan = lifespan;
    }

    /**
     * Returns the type of the lamp.
     * 
     * @return A string representing the type of the lamp
     */
    public String getType() {
        return type;
    }

    /**
     * Returns the energy efficiency of the lamp.
     * 
     * @return The energy efficiency of the lamp in W/Lm
     */
    public double getEnergyEfficiency() {
        return energyEfficiency;
    }

    /**
     * Returns the lifespan of the lamp.
     * 
     * @return The lifespan of the lamp in hours
     */
    public double getLifespan() {
        return lifespan;
    }

    /**
     * Displays the details of the lamp, including its type, energy efficiency, and lifespan.
     * 
     * @return A formatted string with the lamp details
     */
    public String displayDetails() {
        return "Lamp Type: " + type +
               "\nEnergy Efficiency: " + energyEfficiency + " W/Lm" +
               "\nLifespan: " + lifespan + " hours";
    }

    /**
     * Compares the energy efficiency of the current lamp with another lamp.
     * A lower value of W/Lm indicates better energy efficiency.
     * 
     * @param other Another <code>LampType</code> object to compare with
     * @return <code>true</code> if the current lamp is more energy-efficient, 
     *         <code>false</code> otherwise
     */
    public boolean isMoreEfficientThan(LampType other) {
        return this.energyEfficiency < other.energyEfficiency; // Lower W/Lm means more efficient
    }
}

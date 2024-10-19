package ce306.shapoval.lab3;

import java.io.FileNotFoundException;

/**
 * The <code>EnergySavingLamp</code> class extends the abstract class <code>Lamp</code>
 * and implements the <code>Switchable</code> interface.
 */
public final class EnergySavingLamp extends Lamp implements Switchable {
    // Energy efficiency factor (e.g., 0.8 means 80% efficiency)
    private final double energyEfficiency;
    private boolean isOn;

    /**
     * Constructor that initializes the energy-saving lamp with a given battery, socket, and energy efficiency.
     * @param battery Lamp battery
     * @param socket Lamp socket
     * @param energyEfficiency Efficiency factor (1.0 means 100% efficiency)
     * @throws FileNotFoundException
     */
    public EnergySavingLamp(LampBattery battery, LampSocket socket, double energyEfficiency) throws FileNotFoundException {
        super(battery, socket);
        this.energyEfficiency = energyEfficiency;
        this.isOn = false; // Lamp is initially off
    }

    /**
     * Implementation of the <code>turnOn</code> method from the <code>Switchable</code> interface.
     * Turns the lamp on.
     */
    @Override
    public void turnOn() {
        isOn = true;
        fout.println("Лампу увімкнено.");
        fout.flush();
    }

    /**
     * Implementation of the <code>turnOff</code> method from the <code>Switchable</code> interface.
     * Turns the lamp off.
     */
    @Override
    public void turnOff() {
        isOn = false;
        fout.println("Лампу вимкнено.");
        fout.flush();
    }

    /**
     * Implementation of the <code>isOn</code> method from the <code>Switchable</code> interface.
     * @return <code>true</code> if the lamp is on, <code>false</code> otherwise.
     */
    @Override
    public boolean isOn() {
        return isOn;
    }

    /**
     * Method that overrides <code>getLampInfo</code> to provide information about the energy-saving lamp.
     * @return Information about the lamp, including its energy efficiency and status.
     */
    @Override
    public String getLampInfo() {
        String info = super.getLampInfo();
        info += String.format("Енергоефективність лампи: %.2f%%\n", energyEfficiency * 100);
        info += isOn ? "Лампа увімкнена\n" : "Лампа вимкнена\n";

        fout.println(info);
        fout.flush();
        return info;
    }

    /**
     * Method to get the energy efficiency of the lamp.
     * @return The energy efficiency factor.
     */
    public double getEnergyEfficiency() {
        return energyEfficiency;
    }
}

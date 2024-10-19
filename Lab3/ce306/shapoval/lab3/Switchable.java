package ce306.shapoval.lab3;

/**
 * Interface <code>Switchable</code> defines methods to switch the lamp on and off.
 */
public interface Switchable {

    /**
     * Method to switch the lamp on.
     */
    void turnOn();

    /**
     * Method to switch the lamp off.
     */
    void turnOff();

    /**
     * Method to check if the lamp is currently on.
     * @return <code>true</code> if the lamp is on, <code>false</code> otherwise.
     */
    boolean isOn();
}

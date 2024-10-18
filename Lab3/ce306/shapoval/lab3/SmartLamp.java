package ce306.shapoval.lab3;

import java.io.FileNotFoundException;

/**
 * The <code>SmartLamp</code> class extends the abstract class <code>Lamp</code> and implements the <code>Colorable</code> interface.
 */
public final class SmartLamp extends Lamp implements Colorable {
    // Fields to store color components
    protected int red, green, blue;

    /**
     * Constructor that initializes the lamp with a given battery and socket.
     */
    public SmartLamp(LampBattery battery, LampSocket socket) throws FileNotFoundException {
        super(battery, socket);
        // Default light color is white (255, 255, 255)
        this.red = 255;
        this.green = 255;
        this.blue = 255;
    }

    /**
     * Implementation of the method to change the light color.
     * @param r Red component (0-255)
     * @param g Green component (0-255)
     * @param b Blue component (0-255)
     */
    @Override
    public void setColor(int r, int g, int b) {
        this.red = r;
        this.green = g;
        this.blue = b;
        System.out.printf("The lamp color has been changed to RGB(%d, %d, %d)\n", r, g, b);
    }

    /**
     * Implementation of the method to retrieve the current color.
     * @return The current color in RGB format.
     */
    @Override
    public String getColor() {
        return String.format("The current lamp color is: RGB(%d, %d, %d)", red, green, blue);
    }

    /**
     * Implementation of the abstract method <code>getLampInfo</code>.
     * @return Information about the lamp and its color.
     */
    @Override
    public String getLampInfo() {
        String info = super.getLampInfo();
        info += getColor();

        fout.println(info);
        fout.flush();
        return info;
    }
}

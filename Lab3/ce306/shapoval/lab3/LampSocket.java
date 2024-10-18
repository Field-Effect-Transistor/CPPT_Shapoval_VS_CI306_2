package ce306.shapoval.lab3;

/**
 * The <code>LampSocket</code> class represents the socket (or base) of a lamp,
 * which connects the lamp to the electrical supply.
 * It includes attributes such as the type, shape, and diameter of the socket.
 */
public class LampSocket {

    // Fields to store the properties of the socket
    private String type;      // The type of the socket (e.g., E5, G24, B22d)
    private String shape;     // The shape or connection type (e.g., threaded, bi-pin)
    private double diameter;  // The diameter of the socket in millimeters
    
    /**
     * Default constructor initializing with default values (type E5, threaded connection).
     * The diameter is set to 5mm.
     */
    public LampSocket() {
        this.type = "E5";
        this.diameter = 5;
        this.shape = "threaded connection";
    }

    /**
     * Constructor to initialize the socket with specific type, shape, and diameter.
     * 
     * @param type The type of the socket (e.g., E27, G24)
     * @param shape The connection type or shape of the socket (e.g., threaded, bi-pin)
     * @param diameter The diameter of the socket in millimeters
     */
    public LampSocket(String type, String shape, double diameter) {
        this.type = type;
        this.diameter = diameter;
        this.shape = shape;
    }

    /**
     * Returns the type of the socket.
     * 
     * @return A string representing the socket type
     */
    public String getType() {
        return type;
    }

    /**
     * Returns the diameter of the socket in millimeters.
     * 
     * @return The diameter of the socket
     */
    public double getDiameter() {
        return diameter;
    }

    /**
     * Returns the shape or connection type of the socket.
     * 
     * @return A string representing the socket's shape
     */
    public String getShape() {
        return shape;
    }

    /**
     * Sets the type of the socket.
     * 
     * @param type The new type of the socket
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Sets the diameter of the socket in millimeters.
     * 
     * @param diameter The new diameter of the socket
     */
    public void setDiameter(double diameter) {
        this.diameter = diameter;
    }

    /**
     * Sets the shape or connection type of the socket.
     * 
     * @param shape The new shape of the socket
     */
    public void setShape(String shape) {
        this.shape = shape;
    }

    /**
     * Displays detailed information about the socket, including its type, shape, and diameter.
     * 
     * @return A formatted string containing socket details
     */
    public String getSocketInfo() {
        return "Socket Type: " + type + "\n" +
                "Socket Shape: " + shape + "\n" +
                "Socket Diameter: " + diameter + " mm\n";
    }
}

/**
* lab 2 package
*/
package ce306.shapoval;

import java.io.*;

/**
* Class <code>Lamp</code> implements lamp details
*/
public class Lamp {
    private LampBattery battery;
    private LampType type;
    private LampSocket socket;
    private PrintWriter fout;

    /**
    * Default constructor
    * @throws FileNotFoundException
    */
    public Lamp() throws FileNotFoundException {
        battery = new LampBattery();
        type = new LampType();
        socket = new LampSocket();
        fout = new PrintWriter(new File("lamp_log.txt"));
    }

    /**
    * Parameterized constructor
    * @param battery <code>LampBattery</code> object
    * @param type <code>LampType</code> object
    * @param socket <code>LampSocket</code> object
    * @throws FileNotFoundException
    */
    public Lamp(LampBattery battery, LampType type, LampSocket socket) throws FileNotFoundException {
        this.battery = battery;
        this.type = type;
        this.socket = socket;
        fout = new PrintWriter(new File("lamp_log.txt"));
    }

    /**
    * Method returns lamp's information
    * @return Lamp's information
    */
    public String getLampInfo() {
        String info = "Лампа:\n" +
                      battery.checkStatus() + "\n" +
                      type.displayDetails() + "\n" +
                      socket.getSocketInfo();
        fout.println(info);
        fout.flush();
        return info;
    }

    /**
    * Method charges the battery
    * @param amount The amount to charge
    */
    public void chargeBattery(double amount) {
        battery.charge(amount);
        fout.printf("Батарея була заряджена на %.2f мАг.\n", amount);
        fout.flush();
    }

    /**
    * Method discharges the battery
    * @param amount The amount to discharge
    */
    public void dischargeBattery(double amount) {
        battery.discharge(amount);
        fout.printf("Батарея була розряджена на %.2f мАг.\n", amount);
        fout.flush();
    }

    /**
    * Method changes the lamp type
    * @param newType New <code>LampType</code>
    */
    public void changeLampType(LampType newType) {
        this.type = newType;
        fout.println("Тип лампи змінено на: " + newType.getType());
        fout.flush();
    }

    /**
    * Method changes the socket type
    * @param newSocket New <code>LampSocket</code>
    */
    public void changeSocket(LampSocket newSocket) {
        this.socket = newSocket;
        fout.println("Цоколь змінено на: " + newSocket.getType());
        fout.flush();
    }

    /**
    * Method returns the current battery capacity
    * @return Current battery capacity
    */
    public double getCurrentBatteryCapacity() {
        return battery.getCurrentCapacity();
    }

    /**
    * Method checks the status of the lamp
    * @return Current status of the lamp
    */
    public String checkLampStatus() {
        String status = battery.checkStatus();
        fout.println("Стан лампи перевірено: " + status);
        fout.flush();
        return status;
    }

    /**
    * Method releases used resources
    */
    public void dispose() {
        fout.close();
    }

}

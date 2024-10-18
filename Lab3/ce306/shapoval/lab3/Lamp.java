/**
* lab 2 package
*/
package ce306.shapoval.lab3;

import java.io.*;

/**
* Class <code>Lamp</code> implements lamp details
*/
public abstract class Lamp {
    //private Object battery_;
    protected LampBattery battery;
    protected LampSocket socket;
    protected PrintWriter fout;

    /**
    * Default constructor
    * @throws FileNotFoundException
    */
    public Lamp() throws FileNotFoundException {
        battery = null;
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
    public Lamp(LampBattery battery, LampSocket socket) throws FileNotFoundException {
        this.battery = battery;
        this.socket = socket;
        fout = new PrintWriter(new File("lamp_log.txt"));
    }

    /**
    * Method returns lamp's information
    * @return Lamp's information
    */
    public String getLampInfo() {
        String info = "Лампа:\n";
        if (battery != null) {
            info += battery.checkStatus() + "\n";
        }
        info += socket.getSocketInfo();

        fout.println(info);
        fout.flush();
        return info;
    }

    /**
    * Method charges the battery
    * @param amount The amount to charge
    * @return <code>true</code> if the charge was successful, <code>false</code> otherwise
    */
    public boolean chargeBattery(double amount) {
        if(battery != null) {
            battery.charge(amount);
            fout.printf("Батарея була заряджена на %.2f мАг.\n", amount);
            fout.flush();
            return true;
        }
        fout.println("Батарея не існує");
        fout.flush();
        return false;
    }

    /**
    * Method discharges the battery
    * @param amount The amount to discharge
    * @return <code>true</code> if the discharge was successful, <code>false</code> otherwise
    */
    public boolean dischargeBattery(double amount) {
        if (battery != null) {
            battery.discharge(amount);
            fout.printf("Батарея була розряджена на %.2f мАг.\n", amount);
            fout.flush();
            return true;
        }
        fout.println("Батарея не існує");
        fout.flush();
        return false;
    }

    /**
    * Method returns the current battery capacity
    * @return Current battery capacity
    */
    public double getCurrentBatteryCapacity() {
        if (battery == null) {
            fout.println("Батарея не існує");
            fout.flush();
            return 0;
        }

        fout.println("Значення потужності батареєю: " + battery.getCurrentCapacity());
        fout.flush();
        return battery.getCurrentCapacity();
    }

    /**
    * Method checks the status of the lamp
    * @return Current status of the lamp
    */
    public String checkLampStatus() {
        if (battery == null) {
            fout.println("Батарея не існує");
            fout.flush();
            return "Батарея не існує";
        }
        
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

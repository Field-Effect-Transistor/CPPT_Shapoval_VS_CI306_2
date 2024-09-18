package ce306.shapoval;

import java.io.*;

public class LampBattery {
    private double nominalVoltage;
    private double nominalCapacity;
    private double currentCapacity;

    public LampBattery(){
        nominalVoltage = 3.7;
        nominalCapacity = 1500;
        currentCapacity = nominalCapacity;
    }

    public LampBattery(double nominalVoltage, double nominalCapacity) {
        this.nominalVoltage = nominalVoltage;
        this.nominalCapacity = nominalCapacity;
        this.currentCapacity = nominalCapacity;
    }

    public LampBattery(double nominalVoltage, double nominalCapacity, double currentCapacity) {
        this.nominalVoltage = nominalVoltage;
        this.nominalCapacity = nominalCapacity;
        this.currentCapacity = currentCapacity;
    }
    
}
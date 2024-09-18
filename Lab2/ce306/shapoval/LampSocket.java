package ce306.shapoval;

import java.io.*;

public class LampSocket {

    // Enum для типів цоколів
    public enum SocketType {
        E5, E10, E11, E12, E14, E17, E26, E27, E39, E40,
        G4, G5, G9, G10, GU10, G13, G24,
        B15d, B22d, BA15d,
        P14_5s, P20d,
        H1, H4, H7, T10, P43t,
        R7s, S14s, G53,
        G2_7, G2_11
    }

    // Поля класу
    private SocketType type;
    private double diameter; // Діаметр цоколя (для різьбових або байонетних)
    private PrintWriter fout;

    // Конструктор для типу без діаметра
    public LampSocket(SocketType type) {
        this.type = type;
    }
    
    // Конструктор для типу з діаметром
    public LampSocket(SocketType type, double diameter) {
        this.type = type;
        this.diameter = diameter;
    }

    // Геттери
    public SocketType getType() {
        return type;
    }

    public double getDiameter() {
        return diameter;
    }

    // Метод для виведення інформації про цоколь
    public String getSocketInfo() {
        if (diameter > 0) {
            return "Socket type: " + type + ", Diameter: " + diameter + " mm";
        } else {
            return "Socket type: " + type;
        }
    }
}

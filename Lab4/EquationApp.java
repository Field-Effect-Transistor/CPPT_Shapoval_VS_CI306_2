import ce306.shapoval.lab4.*;
import java.util.Scanner;

public class EquationApp {
    public static void main(String[] args) {
        Equation equation = new Equation();
        Scanner in = new Scanner(System.in);
        System.out.print("Enter x in degrees: ");
        System.out.println("y = " + equation.calculate(in.nextDouble()));

    }
}
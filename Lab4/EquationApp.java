import ce306.shapoval.lab4.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class EquationApp {
    public static void main(String[] args) {
        try {
            System.out.print("Enter file name:\t");
            Scanner in = new Scanner(System.in);
            PrintWriter fout = new PrintWriter(new File(in.nextLine()));
            try {
                System.out.print("Enter x in degrees:\t");
                double result = new Equation().calculate(in.nextDouble());
                fout.println(result);
                System.out.println("Result saved to file.");
            } catch (CalcException calcException) {
                System.out.println(calcException.getMessage());
            } finally {
                fout.flush();
                fout.close();
            }
        } catch (FileNotFoundException fileException) {
            System.out.print("Exception reason: perhaps wrong file path");
        }
    }
}

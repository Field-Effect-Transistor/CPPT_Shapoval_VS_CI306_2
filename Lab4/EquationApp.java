import ce306.shapoval.lab4.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * The <code>EquationApp</code> class provides a command-line application for calculating 
 * the result of a mathematical equation based on user input. It prompts the user for 
 * the angle in degrees and saves the result to a specified file.
 */
public class EquationApp {
    /**
     * The entry point of the application. It prompts the user to enter a file name 
     * to save the result of the equation calculation. The user is then asked to input 
     * an angle in degrees, which is passed to the <code>Equation</code> class for 
     * calculation. The result is saved to the specified file.
     *
     * @param args Command line arguments (not used in this application)
     */
    public static void main(String[] args) {
        try {
            System.out.print("Enter file name:\t");
            Scanner in = new Scanner(System.in);
            PrintWriter fout = new PrintWriter(new File(in.nextLine()));
            try {
                System.out.print("Enter x in degrees:\t");
                fout.println(new Equation().calculate(in.nextDouble()));
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

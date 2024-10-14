import ce306.shapoval.lab5.CalcWFio;

import java.util.Scanner;
import java.io.*;

/**
 * The <code>FioApp</code> class implements a console application 
 * for calculating a result using the <code>CalcWFio</code> class 
 * and saving/reading the result from text and binary files.
 */
public class FioApp {

    /**
     * The <code>main</code> method is the entry point of the program. 
     * It prompts the user for the value of <code>x</code>, performs calculations, 
     * and writes/reads the results from files.
     * 
     * @param args Command line arguments
     * @throws IOException If an I/O error occurs
     * @throws FileNotFoundException If the specified file is not found
     */
    public static void main(String[] args) throws IOException, FileNotFoundException {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter value of x: ");
        double x = in.nextDouble();

        // Create an instance of CalcWFio and perform calculations
        CalcWFio calc = new CalcWFio(x);
        calc.calculate(x);
        System.out.println("Result: " + calc.getResult());

        // Write result to text file and read it back
        calc.writeResTxt("res.txt");
        calc.readResTxt("res.txt");
        System.out.println("Result: " + calc.getResult());

        // Write result to binary file and read it back
        calc.writeResBin("res.bin");
        calc.readResBin("res.bin");
        System.out.println("Result: " + calc.getResult());
    }
}

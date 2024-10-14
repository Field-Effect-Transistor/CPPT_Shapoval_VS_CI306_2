package ce306.shapoval.lab5;

import java.io.*;
import java.util.Scanner;

/**
 * The <code>CalcWFio</code> class is responsible for performing calculations
 * and reading/writing the results to both text and binary files.
 */
public class CalcWFio {
    private double result;

    /**
     * Default constructor that initializes the result to 0.0.
     */
    public CalcWFio() {        
        result = 0.0;
    }

    /**
     * Parameterized constructor that accepts a value of <code>x</code>
     * and performs a calculation.
     *
     * @param x The input value for calculation
     */
    public CalcWFio(double x) {
        calculate(x);
    }

    /**
     * This method performs a calculation using the provided value of <code>x</code>.
     *
     * @param x The input value for calculation
     */
    public void calculate(double x) {
        result = (new Equation()).calculate(x);
    }

    /**
     * Returns the result of the calculation.
     *
     * @return The result as a <code>double</code>
     */
    public double getResult() {
        return result;
    }

    /**
     * Writes the result to a text file.
     *
     * @param fname The name of the text file
     * @throws FileNotFoundException If the file cannot be found or created
     */
    public void writeResTxt(String fname) throws FileNotFoundException {
        PrintWriter fout = new PrintWriter(fname);
        fout.printf("%f", result);
        fout.close();
    }

    /**
     * Reads the result from a text file.
     *
     * @param fname The name of the text file
     */
    public void readResTxt(String fname) {
        try {
            File fin = new File(fname);
            if (fin.exists()) {
                Scanner s = new Scanner(fin);
                result = s.nextDouble();
                s.close();
            } else {
                throw new FileNotFoundException("File " + fname + " not found");
            }
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
    }

    /**
     * Writes the result to a binary file.
     *
     * @param fname The name of the binary file
     * @throws IOException If an I/O error occurs
     * @throws FileNotFoundException If the file cannot be found or created
     */
    public void writeResBin(String fname) throws IOException, FileNotFoundException {
        DataOutputStream dout = new DataOutputStream(new FileOutputStream(fname));
        dout.writeDouble(result);
        dout.close();
    } 

    /**
     * Reads the result from a binary file.
     *
     * @param fname The name of the binary file
     * @throws IOException If an I/O error occurs
     */
    public void readResBin(String fname) throws IOException {
        DataInputStream din = new DataInputStream(new FileInputStream(fname));
        result = din.readDouble();
        din.close();
    }
}

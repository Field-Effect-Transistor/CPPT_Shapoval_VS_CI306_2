package ce306.shapoval.lab5;

import java.io.*;
import java.util.Scanner;

public class CalcWFio {
    private double result;
    
    public CalcWFio() {        
        result = 0.0;
    }

    public CalcWFio(double x) {
        calculate(x);
    }

    public void calculate(double x) {
        result = (new Equation()).calculate(x);
    }

    public double getResult() {
        return result;
    }

    public void writeResTxt(String fname) throws FileNotFoundException {
        PrintWriter fout = new PrintWriter(fname);
        fout.printf("%f", result);
        fout.close();
    }

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

    public void writeResBin(String fname) throws IOException, FileNotFoundException {
        DataOutputStream dout = new DataOutputStream(new FileOutputStream(fname));
        dout.writeDouble(result);
        dout.close();
    } 

    public void readResBin(String fname) throws IOException {
        DataInputStream din = new DataInputStream(new FileInputStream(fname));
        result = din.readDouble();
        din.close();
    }
}
import ce306.shapoval.lab5.CalcWFio;

import java.util.Scanner;
import java.io.*;

public class FioApp {
    public static void main(String[] args) throws IOException, FileNotFoundException {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter value of x: ");
        double x = in.nextDouble();
        CalcWFio calc = new CalcWFio(x);
        calc.calculate(x);
        System.out.println("Result: " + calc.getResult());

        calc.writeResTxt("res.txt");
        calc.readResTxt("res.txt");
        System.out.println("Result: " + calc.getResult());

        calc.writeResBin("res.bin");
        calc.readResBin("res.bin");
        System.out.println("Result: " + calc.getResult());
    }
}
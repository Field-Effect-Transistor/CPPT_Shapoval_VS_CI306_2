/****************************************************************************
* Copyright (c) 2013-2023 Lviv Polytechnic National University. All Rights Reserved.
*
* This program and the accompanying materials are made available under the terms
* of the Academic Free License v. 3.0 which accompanies this distribution, and is
* available at https://opensource.org/license/afl-3-0-php/
*
* SPDX-License-Identifier: AFL-3.0
****************************************************************************/
package ce306.shapoval.lab4;

import java.io.*;
import static java.lang.System.out;
import java.util.Scanner;

/**
* Class <code>EquationsApp</code> Implements driver for Equations class
* @author Shapoval
* @version 1.0
*/
public class EquationsApp {
    /**
    * @param args
    */
    public static void main(String[] args) {
        try {
            out.print("Enter file name: ");
            Scanner in = new Scanner(System.in);
            String fName = in.nextLine();
            PrintWriter fout = new PrintWriter(new File(fName));
                try {
                    Equations eq = new Equations();
                    out.print("Enter X: ");
                    double temp = in.nextDouble();
                    out.println(temp);
                    fout.print(eq.calculate(temp));
                } catch (CalcException ex) {
                // Блок перехоплює помилки обчислень виразу
                out.print(ex.getMessage());
                } finally {
                    // Цей блок виконається за будь-яких обставин
                    fout.flush();
                    fout.close();
                }
        } catch (FileNotFoundException ex) {
            // Блок перехоплює помилки роботи з файлом
            out.print("Exception reason: Perhaps wrong file path");
        }
    }
}

/**
* Class <code>CalcException</code> more precise ArithmeticException
* @author Shapoval
* @version 1.0
*/
class CalcException extends ArithmeticException {
    public CalcException() {}
    public CalcException(String cause) {
        super(cause);
    }
}

/**
* Class <code>Equations</code> implements method for calculating y = 1 / ctg(2x)
* @author Shapoval
* @version 1.0
*/
class Equations {
    /**
    * Method calculates the y = 1 / cot(2x) expression
    * @param <code>x</code> Angle in degrees
    * @throws CalcException
    */
    public double calculate(double x) throws CalcException {
        double y, rad;
        rad = 2 * x * Math.PI / 180.0;  // перетворення в радіани
        try {
            double cot2x = 1.0 / Math.tan(rad);  // обчислюємо котангенс
            y = 1.0 / cot2x;  // обчислюємо y = 1 / cot(2x)
            // Якщо результат не є числом або нескінченністю, то генеруємо виключення
            if (Double.isNaN(y) || Double.isInfinite(y)) {
                throw new ArithmeticException();
            }
        } catch (ArithmeticException ex) {
            // Створюємо виключення з поясненням причини помилки
            if (x % 90 == 0) {  // якщо кут рівний 90 градусів, де тангенс не визначений
                throw new CalcException("Exception reason: Illegal value of X for cotangent calculation");
            } else {
                throw new CalcException("Unknown reason for the exception during calculation");
            }
        }
        return y;
    }
}

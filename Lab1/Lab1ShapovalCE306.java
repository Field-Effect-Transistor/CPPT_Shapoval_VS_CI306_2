import java.io.*;
import java.util.Scanner;

/**
 * The <code>Lab1ShapovalCE306</code> class implements an example program based on the requirements 
 * of laboratory work 1. It creates a matrix filled with a user-defined character and displays it in a specific pattern.
 */
public class Lab1ShapovalCE306 {
    /**
     * The main method serves as the entry point for the program. It prompts the user to enter the size of a matrix 
     * and a filler character, creates a triangular matrix with this character, and writes the result to both 
     * the console and a file named <code>MyFile.txt</code>.
     *
     * @param args Command-line arguments (not used)
     * @throws FileNotFoundException if the file <code>MyFile.txt</code> cannot be created or opened
     */
    public static void main(String[] args) throws FileNotFoundException {
        int rows;
        char[][] arr;
        String filler;

        // Scanner for user input
        Scanner in = new Scanner(System.in);
        File dataFile = new File("MyFile.txt");
        PrintWriter fout = new PrintWriter(dataFile);

        // Asking user to input matrix size
        System.out.print("Enter matrix size: ");
        rows = in.nextInt();
        in.nextLine();  // Consume the newline

        if (rows < 1) {
            System.out.print("\nInvalid matrix size");
            return;
        }

        // Asking user to input the filler character
        System.out.print("\nEnter filler character: ");
        filler = in.nextLine();
        if (filler.length() == 0) {
            System.out.print("\nNo filler character entered");
            return;
        } else if (filler.length() > 1) {
            System.out.print("\nToo many characters entered as filler");
            return;
        }

        // Creating matrix with specific triangular shape
        arr = new char[rows][];
        if (rows % 2 == 1) {
            for (int i = 0; i < rows / 2; ++i) {
                arr[i] = new char[i + 1];
                arr[rows - 1 - i] = new char[i + 1];
            }
            arr[rows / 2] = new char[rows / 2 + 1];
        } else {
            for (int i = 0; i < rows / 2; ++i) {
                arr[i] = new char[i + 1];
                arr[rows - 1 - i] = new char[i + 1];
            }
        }

        // Filling the matrix with the user-defined character
        for (int i = 0; i < arr.length; ++i) {
            for (int j = 0; j < arr[i].length; ++j) {
                arr[i][j] = (char) filler.codePointAt(0);
            }
        }

        // Displaying the matrix and writing to the file
        for (int i = 0; i < arr.length; ++i) {
            for (int j = 0; j < rows - arr[i].length; ++j) {
                System.out.print("  ");
                fout.print("  ");
            }
            for (int j = 0; j < arr[i].length; ++j) {
                System.out.print(arr[i][j] + " ");
                fout.print(arr[i][j] + " ");
            }
            System.out.print("\n");
            fout.print("\n");
        }

        // Flushing and closing file writer
        fout.flush();
        fout.close();
    }
}

    import java.io.*;
    import java.util.Scanner;

    /**
    * Клас реалізує приклад програи за вимогами лабораторної роботи 1
    */
    public class Lab1ShapovalCE306 {
        /**
         * Статичний метод main є точкою входу в програму
         * @param args
         * @throws FileNotFoundException
         */
        public static void main(String[] args) throws FileNotFoundException {
            int rows;
            char[][] arr;
            String filler;

            Scanner in = new Scanner(System.in);
            File dataFile = new File("MyFile.txt");
            PrintWriter fout = new PrintWriter(dataFile);

            System.out.print("Введіть розмірність матриці: ");
            rows = in.nextInt();
            in.nextLine();
            if (rows < 1) {
                System.out.print("\nНекоректна розмірність матриці");
                return;
            }

            System.out.print("\nВведіть символ-заповнювач: ");
            filler = in.nextLine();
            if(filler.length() == 0) {
                System.out.print("\nНе введено символ заповнювач");
                return;
            } else if (filler.length() > 1) {
                System.out.print("\nЗабагато символів заповнювачів");
                return;
            }



            arr = new char[rows][];
            if (rows % 2 == 1) {
                for(int i = 0; i < rows / 2; ++i) {
                    arr[i] = new char[i + 1];
                    arr[rows - 1 - i] = new char[i + 1];
                }
                arr[rows / 2] = new char[rows / 2 + 1];
            } else {
                for(int i = 0; i < rows / 2; ++i) {
                    arr[i] = new char[i + 1];
                    arr[rows - 1 - i] = new char[i + 1];
                }
            }

            for(int i = 0; i < arr.length; ++i) {
                for(int j = 0; j < arr[i].length; ++j) {
                    arr[i][j] = (char) filler.codePointAt(0);
                }
            }

            for(int i = 0; i < arr.length; ++i) {
                for(int j = 0; j < rows - arr[i].length; ++j) {
                    System.out.print("  ");
                    fout.print("  ");
                }
                for(int j = 0; j < arr[i].length; ++j) {
                    System.out.print(arr[i][j] + " ");
                    fout.print(arr[i][j] + " ");
                }
                System.out.print("\n");
                fout.print("\n");
            }

            fout.flush();
            fout.close();
        }
    }
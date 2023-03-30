package JavaOrgExample.One.Two.IO;

import java.io.*;
import java.util.Scanner;

/**
 * * <p>
 * * java.io.FileReader
 * * java.io.FileWriter
 * * </p>
 * * <p>
 * * java.io.BufferedReader
 * * java.io.PrintWriter
 * * </p>
 */
public class ScanDemo {
    public static void main(String[] args) {
        try (FileReader fileReader = new FileReader("in.txt");
             BufferedReader reader = new BufferedReader(fileReader);
             Scanner scanner = new Scanner(reader)) {
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}


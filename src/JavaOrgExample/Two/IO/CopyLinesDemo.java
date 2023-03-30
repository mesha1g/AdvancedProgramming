package JavaOrgExample.Two.IO;

import java.io.*;

/**
 * <p>
 * java.io.FileReader
 * java.io.FileWriter
 * </p>
 * <p>
 * java.io.BufferedReader
 * java.io.PrintWriter
 * </p>
 */
public class CopyLinesDemo {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader("in.txt"));
             PrintWriter out = new PrintWriter(new FileWriter("out4.txt"));) {
            String line = "";
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
                out.println(line);
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}

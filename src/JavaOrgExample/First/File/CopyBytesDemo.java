package JavaOrgExample.First.File;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * byte po byte...
 * <p>
 * java.io.FileInputStream inputReader
 * java.io.FileOutputStream outputReader
 * </p>
 * try-catch
 * <p>
 * Java 1.7 -> TRY WITH RESOURCE
 */
public class CopyBytesDemo {
    public static void main(String[] args) {
        try (FileInputStream inputReader = new FileInputStream("in.txt");
             FileOutputStream outputWriter = new FileOutputStream("out.txt");
        ) {
            int dataByte;
            while ((dataByte = inputReader.read()) != -1) {
                System.out.print((char) dataByte);
                outputWriter.write(dataByte);
            }
            System.out.println(dataByte);
        } catch (IOException exception) {
            System.err.println(exception.getMessage());
        }
    }
}

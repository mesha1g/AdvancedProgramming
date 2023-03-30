package JavaOrgExample.Two.IO;

import java.io.File;
import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

public class ScanDemo2 {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new File("in.txt"))) {
            while(scanner.hasNext()){
                if (scanner.hasNextDouble()) {
                    scanner.useLocale(Locale.UK);
                    Double number = scanner.nextDouble();
                    System.out.println(number);
                }else{
                    scanner.next();
                }
            }

        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}

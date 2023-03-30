package JavaOrgExample.One.Exception;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class ExceptionDemo {
    public static void main(String[] args) {
        System.out.println("Unesite neki broj..");
        int[] numbers = new int[3];
        int number = new Scanner(System.in).nextInt();
        //UNCHECKED
        System.out.println(number / 0);
        numbers[33] = number;
        System.out.println("Uneseni broj je: " + number);
        //CHECKED exception

        try {
            readFile("sadrzaj.txt");
        }catch (FileNotFoundException exception){
            System.err.println(exception.getMessage());
        }

    }

    static void readFile(String imeFajla) throws FileNotFoundException {
        //blok koda koji se kači na neki fajl
    }
}

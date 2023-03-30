package JavaOrgExample.Two.IO;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * java.io.FileReader
 * java.io.FileWriter
 */
public class CopyCharacters {
    public static void main(String[] args) {
        try(FileReader reader = new FileReader("in.txt");
            FileWriter writer = new FileWriter("out3.txt");
        ){
            int charOfContent;
            while ((charOfContent = reader.read())!=-1){
                System.out.print((char)charOfContent);
                writer.write(charOfContent);
            }
        }catch (IOException e){
            System.err.println(e.getMessage());
        }
    }
}


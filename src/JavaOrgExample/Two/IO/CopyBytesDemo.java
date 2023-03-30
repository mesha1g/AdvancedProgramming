package JavaOrgExample.One.Two.IO;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Sadržaj fajla možemo kopirati byte po byte.
 * <p>
 *     java.io.FileInputStream
 *     java.io.FileOutputStream
 * </p>
 * <p>
 *     <1.7 --->
 *     try-catch-finnally
 *     1.7 try-with-resource
 *
 * </p>
 */
public class CopyBytesDemo {
    public static void main(String[] args) {
        //   NasReader nasReader = new NasReader();
        try(FileInputStream fin = new FileInputStream("in.txt");
            FileOutputStream out = new FileOutputStream("out2.txt");
        ){
            int jedanBajt;
            while((jedanBajt = fin.read())!=-1){
                char slovo = (char) jedanBajt;
                System.out.print(slovo);
                out.write(jedanBajt);
            }
            System.out.println();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}


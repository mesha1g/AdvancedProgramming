package JavaOrgExample.One.Two.IO;

import java.io.Closeable;

public class NasReader implements Closeable {
    @Override
    public void close()  {
        System.out.println("Neko pozvao funkciju close...");
    }
}
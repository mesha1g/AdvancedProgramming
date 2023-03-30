package JavaOrgExample.Seven.Singleton.v1;

import java.io.Serializable;

/**
 * EAGER INSTANTIATION version of singleton
 * <p>
 * LAZY INSTATION of singleton
 * </p>
 */

public class Singleton implements Serializable {

    private static Singleton INSTANCE;
    private Singleton() {
        System.out.println("Instanciram singleton...");
    }

    public static Singleton getInstance(){
        if(INSTANCE == null){
            INSTANCE = new Singleton();
        }
        return INSTANCE;
    }
}

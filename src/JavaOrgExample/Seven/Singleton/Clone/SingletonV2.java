package JavaOrgExample.Seven.Singleton.Clone;

public class SingletonV2 implements Cloneable{

    private static SingletonV2 INSTANCE = new SingletonV2();

    private SingletonV2() {
        System.out.println("Poziva se konstruktor Singleton V2....");
    }

    public static SingletonV2 getInstance() {
        return INSTANCE;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}


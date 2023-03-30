package JavaOrgExample.Seven.Singleton;

public enum Singleton {
    INSTANCE;

    private Singleton(){
        System.out.println("Kreiram instancu pozivajuc konstruktor...");
    }
}

package JavaOrgExample.Seven.Singleton.Serialization;



import JavaOrgExample.Seven.Singleton.v1.Singleton;

import java.io.*;

public class SingletonDemo {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Singleton singleton1 = Singleton.getInstance();
        System.out.println(singleton1.hashCode());
        Singleton singleton2 = Singleton.getInstance();
        System.out.println(singleton2.hashCode());
        //serijalizovati singleton1 ili singleton2 u fajl
        ObjectOutputStream ous = new ObjectOutputStream(new FileOutputStream("s2.ser"));
        ous.writeObject(singleton1);
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("s2.ser"));
        Singleton singleton3 = (Singleton) ois.readObject();
        System.out.println(singleton3.hashCode());
    }
}

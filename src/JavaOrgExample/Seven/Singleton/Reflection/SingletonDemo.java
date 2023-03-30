package JavaOrgExample.Seven.Singleton.Reflection;



import JavaOrgExample.Seven.Singleton.v1.Singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class SingletonDemo {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, ClassNotFoundException {
        Singleton singleton1 = Singleton.getInstance();
        System.out.println(singleton1.hashCode());
        Singleton singleton2 = Singleton.getInstance();
        System.out.println(singleton2.hashCode());
        //Refleksija
        Class<Singleton> refleksijaSingleton = (Class<Singleton>) Class.forName("org.example.seven.singleton.v1.Singleton");
        //singleton1.getClass();
        Constructor<Singleton> singletonovConstruktor = refleksijaSingleton.getDeclaredConstructor();
        singletonovConstruktor.setAccessible(true);
        System.out.println(singletonovConstruktor);
        Singleton singleton3 = singletonovConstruktor.newInstance();
        System.out.println(singleton3.hashCode());
    }
}

package JavaOrgExample.Seven.Singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class SingletonDemo {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Singleton singleton1 = Singleton.INSTANCE;
        Singleton singleton2 = Singleton.INSTANCE;
        System.out.println(singleton1.hashCode());
        System.out.println(singleton2.hashCode());

        //Refleksija
        Class andeoCuvar = singleton1.getClass();
        Constructor constructor = andeoCuvar.getDeclaredConstructor();
        Singleton singleton3 = (Singleton) constructor.newInstance();
        System.out.println(singleton3.hashCode());
    }
}

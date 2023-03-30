package JavaOrgExample.Seven.Singleton;


import JavaOrgExample.Seven.Singleton.Clone.SingletonV2;

public class SingletonTester {
    public static void main(String[] args) throws CloneNotSupportedException {
//        Singleton singleton1 = Singleton.getInstance();
//        System.out.println(singleton1.hashCode());
//        Singleton singleton2 = Singleton.getInstance();
//        System.out.println(singleton2.hashCode());


        SingletonV2 singletonV2 = SingletonV2.getInstance();
        System.out.println(singletonV2.hashCode());
        SingletonV2 singletonV21 = (SingletonV2) singletonV2.clone();
        System.out.println(singletonV21.hashCode());
    }
}


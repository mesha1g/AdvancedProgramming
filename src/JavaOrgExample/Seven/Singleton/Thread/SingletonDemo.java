package JavaOrgExample.Seven.Singleton.Thread;



import JavaOrgExample.Seven.Singleton.v1.Singleton;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Proces -> najmanje JEDAN Thread
 * MAIN
 * radnika : Thread
 * <p>
 * run(){
 * <p>
 * }
 * <p>
 * extends Thread
 * implements Runnable
 *
 * <p>
 * Thread Pool
 * </p>
 */
public class SingletonDemo {
    public static void main(String[] args) {
        Singleton singleton1 = Singleton.getInstance();
        Singleton singleton2 = Singleton.getInstance();
        System.out.println(singleton1.hashCode());
        System.out.println(singleton2.hashCode());
       /* new Thread(() -> {
            Singleton singleton = Singleton.getInstance();
            System.out.println(singleton.hashCode());
        }).start();
        new Thread(() -> {
            Singleton singleton = Singleton.getInstance();
            System.out.println(singleton.hashCode());
        }).start();*/
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        executorService.submit(()->{
            var singleton = Singleton.getInstance();
            System.out.println(singleton.hashCode());
        });
        executorService.submit(()->{
            var singleton = Singleton.getInstance();
            System.out.println(singleton.hashCode());
        });
        executorService.submit(()->{
            var singleton = Singleton.getInstance();
            System.out.println(singleton.hashCode());
        });
        executorService.shutdown();
    }
}

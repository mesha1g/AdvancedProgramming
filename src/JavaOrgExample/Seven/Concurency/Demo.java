package JavaOrgExample.Seven.Concurency;

public class Demo {
    public static void main(String[] args) {
        //print();
        new HelloThread().run();
        new HelloThread().start();
        Runnable runnable = new HelloRunnable();
        new Thread(runnable).start();
    }

    static void print(){
        Thread thread = Thread.currentThread();
        System.out.println("Vozdra raja s MySQL. Na žalost radimo Javu prva časa. Ovaj ispis je omogućio:"+thread.getName());
    }
}

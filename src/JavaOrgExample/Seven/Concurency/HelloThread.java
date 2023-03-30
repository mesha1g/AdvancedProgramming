package JavaOrgExample.Seven.Concurency;

public class HelloThread extends Thread{

    @Override
    public void run() {
        Thread thread = Thread.currentThread();
        System.out.println("Vozdra kaže: " + thread.getName());
    }
}

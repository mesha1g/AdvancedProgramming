package JavaOrgExample.Seven.Concurency;

public class Counter {
    private int number = 23;

    public  void increment(){
        synchronized(this) {
            number++;
        }

    }

    public synchronized void decrement(){
        number--;
    }
}

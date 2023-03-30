package JavaOrgExample.Seven.Concurency;

/**
 * <li>1. IO intenzivne</li>
 * <li>2. computational intezivne operacije</li>
 */
public class SleepMesssages {
    public static void main(String[] args) throws InterruptedException {

        Runnable runnable = new MessageLoop();
        Thread drugiRadnik = new Thread(runnable);
        long startTime = System.currentTimeMillis();
        drugiRadnik.start();
        long strpljenje = 10000;
        while (drugiRadnik.isAlive()) {
            if ((System.currentTimeMillis() - startTime) < strpljenje) {
                Thread.sleep(1000);
                System.out.println("Još te čekam...:: " + Thread.currentThread().getName());
            } else {
                System.out.println("Nemam više strpljenja s tobom..");
                drugiRadnik.interrupt();
                drugiRadnik.join();
            }
        }
    }

    static class MessageLoop implements Runnable {
        //16 0000 ms -> 16 s
        @Override
        public void run() {
            String[] messages = {
                    "Danas je bio divan dan",
                    "Mislili smo da će tako i ostati",
                    "Nadali smo se MySQL-u",
                    "Međutim, prva dva časa radimo Javu"
            };
            //java.lang.Thread
            for (String message : messages) {
                //sleep - linija ispod...
                try {
                    Thread.sleep(4000l);
                } catch (InterruptedException e) {
                    System.err.println(e.getMessage());
                }
                System.out.println(message + " :: " + Thread.currentThread().getName());
            }
        }
    }
}

package JavaOrgExample.Seven.Concurency;

public class DeadLockSimulation {

    static class Friend{
        private final String name;

        public Friend(String name){
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public synchronized void bow(Friend bower){
            System.out.println(this.name+" se naklonio " + bower.name);
            bower.bowBack(this);
        }

        public synchronized void bowBack(Friend bower){
            System.out.println(this.name+" je uzvration naklon "+ bower.name);
        }
    }

    public static void main(String[] args) {
        Friend mirsad = new Friend("Mirsad");
        Friend eldar = new Friend("Eldar");
        new Thread(()->mirsad.bow(eldar)).start();
        new Thread(()->eldar.bow(mirsad)).start();
    }
}

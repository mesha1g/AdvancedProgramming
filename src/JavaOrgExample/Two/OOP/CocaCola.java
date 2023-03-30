package JavaOrgExample.Two.OOP;

public class CocaCola extends Beverage{
    public CocaCola() {
        super("Coca Cola");
    }

    @Override
    public double cost() {
        return 3.5;
    }

    @Override
    public void drink() {
        System.out.println("Pije se Coca Cola...");
    }
}

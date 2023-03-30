package JavaOrgExample.Two.OOP;

public class Esspresso extends Beverage{
    public Esspresso() {
        super("Espresso");
    }

    @Override
    protected double cost() {
        return 2.0;
    }

    @Override
    public void drink() {
        System.out.println("Pijem esspresso...");
    }
}

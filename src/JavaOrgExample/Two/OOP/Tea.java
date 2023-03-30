package JavaOrgExample.Two.OOP;

public class Tea extends Beverage{
    public Tea() {
        super("Čaj");
    }

    @Override
    public double cost() {
        return 2.5;
    }

    @Override
    public void drink() {
        System.out.println("Očajavam ");
    }
}

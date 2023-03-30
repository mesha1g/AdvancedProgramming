package JavaOrgExample.One.Two.OOP.Demo;


import JavaOrgExample.One.Two.OOP.Beverage;

public class IrishDecorator extends Beverage {

    private Beverage beverage;

    public IrishDecorator(Beverage beverage) {
        super(" s Bailleys");
        this.beverage = beverage;
    }

    @Override
    protected double cost() {
        return 5;
    }

    @Override
    public void drink() {
        System.out.println(beverage.getName()+" s Baileys pijem..");
    }
}
